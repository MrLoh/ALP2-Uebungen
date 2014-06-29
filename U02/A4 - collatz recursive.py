def collatz(n):
	'''Gibt die Collatz Folge als Liste aus, welche mit der gegebenen Zahl startet.'''
	def next_collatz(cn):
		'''Berechnet die der gegebenen Zahl folgende Collatz Zahl'''
		if cn%2 == 0: return int(cn/2)
		else: return cn*3+1
	if n == 1:
		return [n]
	else:
		return [n] + collatz(next_collatz(n))

# Test
print(collatz(12))
print('Die Rekursive variante ist zeitlich und Platz mäßig weniger effektiv als die iterative, da sie deutlich mehr aufrufe benötigt und mehr variaben zwischenspeichern muss. Im allgemeinen kann eine rekursive Implemetierung übersichtlicher sein. Man kann allerdings bezweifeln, inwiefern dass bei diesem Beispiel zutrifft.')