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

# Test
for i in range(10):
	print(rand_dupl(0,1000))