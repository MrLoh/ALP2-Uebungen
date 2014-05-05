def apply_if(p,f,xs):
	'''Wendet die gegebene Funktion f auf alle Elemente x der Liste xs an, für die p(x) gilt und gibt eine Liste mit den Elementen, auf die f angewendet wurde zurück.'''
	res = []
	for x in xs:
		if p(x):
			res += [f(x)]
	return res

# Test
def ungerade(x):
	if x%2 == 0: return False
	else: return True
def quadrat(x):
	return x**2

print(apply_if(ungerade,quadrat,[2, 3, 1, 9, 4, 0, 5]))