def teiler_sum(n):
	'''gibt die Summe der Teiler einer natürlichen Zahl aus'''
	sum = 0
	for i in range(1,n//2+1):
		if n%i == 0:
			sum += i
	return sum

def befreundet(a,b):
	'''gibt den Wahrheitswert der Frage zurück ob zwei gegebene ganze Zahlen befreundet sind'''
	if b == teiler_sum(a) and a == teiler_sum(b):
		if a != b:
			return True
		else:
			return 'befreundet aber identisch'
	else:
		return False

# Test
print(befreundet(284,220))
print(befreundet(9773505,11791935))
print(befreundet(6,6))
print(befreundet(10,6))