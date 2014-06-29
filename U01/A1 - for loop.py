def my_sum(a):
	'''gibt die Summe der Elemente einer gegebenen Liste von Zahlen zurück'''
	res = 0
	for n in a:
		res += n
	return res

# Test
print(my_sum([11,11]))
print(my_sum([1,2,3,4,5,6,7,8,9,10]))