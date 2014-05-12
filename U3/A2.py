def sort(L): 
	'''Sortiert die gegebene Liste mit Quicksort.'''
	if len(L) <= 1:
		return L
	else:
		return sort([x for x in L[1:] if x<L[0]]) + [L[0]] + sort([x for x in L[1:] if x>=L[0]])

def majority(L):
	'''Testet ob eine Liste ein Element enthält, welches die Mehrheit darstellt und gibt dieses zurück, ansonsten wird "keine Majority" zurück gegeben. '''
	size = len(L)
	sort(L)
	cur_count = 1
	max_count = 0
	for i in range(size):
		if i < size-1 and L[i] == L[i+1]: 
			cur_count += 1
		else: 
			if cur_count > max_count:
				max_count = cur_count
				max_el = L[i]
			cur_count = 1
	if L != [] and max_count > size//2: return max_el
	else: return "keine Majority"

# Test
for L in [ [], [1], [1,1,1,0,0,0,0,], ["a","a","b","b","c","c"], ["a","a","b","b","c","c","c","c","c"] ]:
	print(L)
	print(majority(L))

# Der majority Algorythmus muss zunächst die Liste sortieren. Dies geschieht mit Quicksort mit einer durchschnittlichen Komplexität von O(n*log(n)) Vergleichsoperationen oder schlimmstenfalls O(n^2), wobei n die Länge der Liste ist. Danach muss die Liste nur einmal durchgegangen werden, somit ergibt sich eine Komplexität von O(n) für die restlichen Operationen. Insgesamt ergibt sich damit eine komplexität von O(n*log(n)) oder im schlimmsten Fall O(n^2).