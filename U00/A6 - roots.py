n = int(raw_input("gimme an int: "))

solvable = False
for pwr in range(6):
	for root in range(n):
		if n == root**pwr:
			print "%s^%s equals %s." % (root, pwr, n)
			solvable = True
			break

if not solvable: 
	print "%s has no roots." % (n)