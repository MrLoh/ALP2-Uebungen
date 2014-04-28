def echtTeiler(n):
	divs = []
	for m in range(1,n):
		if n%m == 0:
			divs += [m]
	return divs

print(echtTeiler(250))