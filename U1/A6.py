def teiler_sum(n):
	sum = 0
	for i in range(1,n//2+1):
		if n%i == 0:
			sum += i
	return sum

def n_freunde(n):
	S = [teiler_sum(i) for i in range(n+1)]
	paare = []
	for i in range(1,n+1):
		if i in S and S[i] < i and S[S[i]]==i:
			paare += [(i,S[i])]
	return paare

print(n_freunde(10000))