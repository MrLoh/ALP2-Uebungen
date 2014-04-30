def teiler_sum(n):
	'''gibt die Summe der Teiler einer natürlichen Zahl aus'''
	sum = 0
	for i in range(1,n//2+1):
		if n%i == 0:
			sum += i
	return sum

def n_freunde(n):
	'''gibt eine Liste aller befreundeten Zahlenpaar Tupel kleiner einer gegebenen ganzen Zahl aus''' 
	S = [teiler_sum(i) for i in range(n+1)]
	paare = []
	for i in range(1,n+1):
		if S[i] < i and S[S[i]]==i:
			paare += [(i,S[i])]
	return paare

# Test
print(n_freunde(10000))