from random import randint

# Aufgabenteil a)
def field_creation_heper(p):
	'''gibt "x" mit der in Prozent gegebenen Wahrscheinlichkeit zurück, ansonsten wird "." zurück gegeben. Der Prozentwert wird auf eine ganze Zahl abgerundet.'''
	if randint(0,99) < p: return 'x'
	else: return '.'

def new_play(p=5, n=10, m=20):
	'''gibt eine nxm Matix mit einträgen zurück, die mit einer gegebenen Wahrscheinlichkeit "x" und ansonsten "." enthalten.'''
	return [[field_creation_heper(p) for j in range(m)] for i in range(n)]

# Aufgabenteil b)
def surrounding_generator(i,j):
	'''Gibt eine Liste mit Koordinaten-Paaren von Elementen zurück, die an ein Pivot Element mit Koordinaten i,j angrenzen.'''
	return [ [a,b] for a in range(i-1,i+2) for b in range(j-1,j+2) if not (a==i and b==j) ]

def solution_helper(field,i,j):
	'''Addiert 1 zu den Elementen einer Matrix field, die direkt an ein Pivot Element mit Koordinaten i,j angrenzen.'''
	n,m = len(field),len(field[0])
	for index in surrounding_generator(i,j):
		if index[0] in range(n) and index[1] in range(m):
			selec = field[index[0]][index[1]]
			if field[index[0]][index[1]] != "x":
				if selec == ".": field[index[0]][index[1]] = 1
				else: field[index[0]][index[1]] += 1

def generate_solution(field):
	'''füllt Minsweeper-Zahlen in der Matrix ein, für all Elemente, die um ein Kästchen liegen'''
	n,m = len(field),len(field[0])
	for i in range(n):
		for j in range(m):
			if field[i][j] == "x":
				solution_helper(field,i,j)

# Aufgabenteil c)
def print_field(field,x="x"):
	'''Printed die gegebenen Matrix als Feld'''
	n,m = len(field),len(field[0])
	for i in range(n):
		line = " "
		for j in range(m):
			el = field[i][j]
			if el == "x":
				line += x+" "
			else:
				line += str(el)+" "
		print(line)

# Aufgabenteil d)
def start_play(p=5,n=20,m=30):
	'''Generiert ein Spielfeld und printed ein verdecktes Feld.'''
	solution = new_play(p,n,m)
	generate_solution(solution)
	field = [ ["x" for j in range(m)] for i in range(n)]
	# print_field(field)
	return field,solution

# Aufgabenteil e)
def input_handler(ask,maximum):
	'''Bittet um Eingabe einer Zeile oder Spalte (ask) im Wertebereich von 0 bis maximum, bis eine akzeptable Eingabe erfolgt ist.'''
	input_msg = "Gib die Nummer einer %s swischen 0 und %s an: \t --> "
	type_error_msg = "FEHLER! Du hast keine ganze Zahl für die %s eingegeben."
	range_error_msg = "FEHLER! Die eingegebene %s liegt außerhalb des Feldes."
	while True:
		try:
			pos = int(input(input_msg % (ask, maximum-1) ))
			if pos in range(maximum): return pos
			else: print(range_error_msg % ask)
		except ValueError: 
			print(type_error_msg % ask)

def field_updater(field,solution,x,y,playing):
	'''Updated das Spielfeld nach den Minesweeper regeln für ein Aufdecken an Position x,y und stellt fest, ob das Spiel mit dem Zug gewonnen und beendet wurde. Gibt einen boolschen Wert für den Spielandauerzustand und den Gewinnzustand und das upgedatete feld zurück.'''
	n = len(field)
	m = len(field[0])
	win = False
	if solution[x][y] == "x":
		solution[x][y] = "█"
		field = solution
		playing = False
	else:
		if solution[x][y] != ".":
			field[x][y] = solution[x][y]
		else:
			field[x][y] = solution[x][y]
			for index in surrounding_generator(x,y):
				x,y = index[0],index[1]
				if x in range(0,n) and y in range(0,m) and field[x][y] == "x":
					field_updater(field,solution,x,y,playing)
		if field == solution: 
			win = True
			playing = False
	return playing,win,field

def play(p=15,n=10,m=15):
	'''Startet ein interaktives Minesweeper Spiel.'''
	field,solution = start_play(p,n,m)
	# print_field(solution,"✖")
	playing = True
	while playing:
		print_field(field)
		print("\nGib die Zeile und Spalte an, die aufgedeckt werden sollen:")
		x = input_handler("Zeile",n)
		y = input_handler("Spalte",m)
		print("\nSpielfeld wird an der Stelle %s, %s aufgedeckt:" % (x,y))
		playing,win,field = field_updater(field,solution,x,y,playing)
		print()
	print_field(solution,"✖")
	if win: print("\n\tYou won! :)")
	else: print("\n\tYou lost! :(")

# Spiel
play()