def echtTeiler(n):
	'''gibt eine Liste mit den echten Teilern einer gegebenen ganzen Zahl zurück'''
	divs = []
	for m in range(1,n):
		if n%m == 0:
			divs += [m]
	return divs

# Test
print(echtTeiler(9))
print(echtTeiler(91))
print(echtTeiler(250))