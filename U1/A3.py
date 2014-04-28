from A1 import sum
from A2 import echtTeiler 

def befreundet(a,b):
	if b == sum(echtTeiler(a)) and a == sum(echtTeiler(a)):
		return True
	else:
		return False

print(befreundet(6,6))
print(befreundet(6,5))