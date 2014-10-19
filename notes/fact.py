def fact_rec(n):
	if n == 0:
		return 1
	else:
		return n*fact_rec(n-1)

def fact_iter(n):
	f = n
	for i in range(1,n):
		f *= i
	return f

def fact_endrec(n):
	def helper(i,j):
		if i == 0:
			return 1
		elif i == 1:
			return j
		else:
			return helper(i-1,j*(i-1))
	return helper(n,n)

n=3
print(fact_rec(n))
print(fact_iter(n))
print(fact_endrec(n))
print()

n=4
print(fact_rec(n))
print(fact_iter(n))
print(fact_endrec(n))
print()

n=5
print(fact_rec(n))
print(fact_iter(n))
print(fact_endrec(n))
print()
