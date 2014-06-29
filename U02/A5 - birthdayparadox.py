# Aus Aufgabe 3
from random import randint
def rand_dupl(mi,ma):
	'''Gibt aus, nach wievielen Zufallszahlen zwischen mi und ma, die erste Wiederholung auftaucht'''
	tests = {}
	i = 0
	while True:
		n = randint(mi,ma)
		tests[i] = n
		i += 1
		if n in tests: break
	return len(tests)
year = 365

def double_birthday():
	'''Gibt aus nach wie vielen Versuchen zufällig zwei gleiche Geburtstage zugeordnet werden.'''
	return rand_dupl(1,year)

def repeat_double_birthday(iterations):
	'''Gibt eine Liste L aus, in der für jedes Element L_i die Anzahl steht, wie häufig nach 0<=i<=356 Versuchen zufällig derselbe Geburtstag erzeugt wurde. Dabei wird '''
	L = [0]*(year+1)
	for i in range(iterations):
		L[double_birthday()] += 1
	return L

def birthday_paradox(guests,iterations=10000):
	'''Gibt die Wahrscheinlichkeit aus, mit der mindestens 2 aus einer gegebenen Anzahl von Menschen, am selben Tag Geburtstag haben. Optional kann die Anzahl der Iterationen für die Berechnung angegeben werden.'''
	L = repeat_double_birthday(iterations)
	res = 0
	for i in range(guests):
		res += L[i]
	return res/iterations

# Test
for i in [5,10,20,50,100]:
	print("p(doppelter Geburtstag auf Party mit %d Gästen) = %.2f%%" % (i, birthday_paradox(i)*100))