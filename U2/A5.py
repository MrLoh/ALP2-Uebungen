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
	return rand_dupl(1,year)

def repeat_double_birthday(iterations):
	L = [0]*(year+1)
	for i in range(iterations):
		L[double_birthday()] = i
	return L

def birthday_paradox(guests,iterations):
	L = repeat_double_birthday(iterations)
	# res = 0
	# for i in range(guests):
	# 	res += L[i]
	# 	print('res:',res)
	return L[guests]/iterations

print(repeat_double_birthday(10000))
# print(birthday_paradox(20,10000))