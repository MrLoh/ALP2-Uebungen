def teiler_sum(n):
	sum = 0
	for i in range(1,n):
		if n%i == 0:
			sum += i
	return sum

def befreundet(a,b):
	if b == teiler_sum(a) and a == teiler_sum(b):
		return True
	else:
		return False

print(befreundet(284,220))
print(befreundet(6,5))