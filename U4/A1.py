# Aufgabenteil a)
def is_sorted(L):
	'''Kontrolliert ob eine Liste sortiert ist, für ansteigend sortierte Listen wird 1 zurüch gegeben, für absteigend sortierted Listen -1, für unsortierte 0 und für Listen mit gleichem Element None.'''
	sort = None
	i = 0
	while sort == None and i+1 < len(L):
		if L[i] < L[i+1]: 
			#Liste ist nicht absteigend
			sort = 1
		elif L[i] > L[i+1]: 
			#Liste ist nicht aufsteigend
			sort = -1 
		i += 1
	while sort == 1 and i+1 < len(L):
		if L[i] > L[i+1]: 
			#Liste ist weder auf- noch absteigend
			sort = 0
		i += 1
	while sort == -1 and i+1 < len(L):
		if L[i] < L[i+1]: 
			#Liste ist weder ab- noch aufsteigend
			sort = 0
		i += 1
	return sort

# Tests
L1 = [1,2,3,4,5]
L2 = [5,4,3,2,1]
L3 = [5,4,3,1,2]
L4 = [1,2,3,5,4]
L5 = [0,0]
for L in [L1,L2,L3,L4,L5]:
	print(is_sorted(L))
print()

# Aufgabenteil b)
from random import randint
def generate_random_list(a=0,b=99,n=50):
	'''Generiert eine Liste der Länge n mit ganzen Zufallszahlen im Bereich zwischen a und b.'''
	return [ randint(a,b) for i in range(n) ]

# Aufgabenteil c)
def bubble_sort(L,lo,up):
	'''Sortiert den abschnitt zwischen lo und up der gegebene Liste L mit Bubble-Sort.'''
	remain_up = up-1
	done = False
	while not done:
		done = True
		for i in range(lo,remain_up):
			if L[i] > L[i+1]:
				done = False
				L[i], L[i+1] = L[i+1], L[i]
		remain_up -= 1

def merge(L,H,lo,up,mid):
	'''Merged die beiden Listenabschnitte von L zwischen lo-mid und mid-up in der Hilfsliste H.'''
	i = lo
	j = mid
	for k in range(lo,up):
		if i < mid and j < up:
			if L[i] <= L[j]:
				H[k] = L[i]
				i += 1
			else:
				H[k] = L[j]
				j += 1
		elif i < mid:
			H[k] = L[i]
			i += 1
		elif j < up:
			H[k] = L[j]
			j += 1

def merge_sort(L,H,lo,up,length,threshold=9):
	'''Sortiert die Liste L zwischen up und lo. Dabei wird die Hilfsliste H verwendet und die Liste wird an der Stelle lo+length geteilt. Up threshold wird Bubble-Sort verwendet.'''
	if length <= threshold:
		# print("SORTING:\nlength: %s, lo: %s, up: %s" % (length,lo,up))
		# print(" L: %s \n  ->" % (L) )
		bubble_sort(L,lo,up)
		# print(" L: %s \n" % (L) )
	else:
		mid = lo+length
		L = merge_sort(L,H,lo,mid,length//2,threshold) #rekursiv die erste Hälfte sortieren
		L = merge_sort(L,H,mid,up,length//2,threshold) #rekursiv die zweite Hälfte sortieren
		# print("MERGING:\nlength: %s, lo: %s, up: %s, mid: %s" % (length,lo,up,mid))
		# print(" L: %s \n H: %s \n  ->" % (L,H) )
		merge(L,H,lo,up,mid)
		# print(" H: %s \n" % (H) )
		L = H[:] #L updaten
	return L

def merge_sort_init(L,threshold=9):
	'''Sortiert die Liste L mit Mergesort. Optional, kann angegeben werden, ab welchem threshold Bubble-Sort benutzt werden soll.'''
	if len(L) < threshold:
		bubble_sort(L,0,len(L))
	else:
		H = L[:]
		length = len(L)//2 #gibt die Länge der zu mergenden Listen an
		L = merge_sort(L,H,0,len(L),length,threshold)
	return L

# Tests
for i in range(10):
	L = generate_random_list(0,20,16)
	L = merge_sort_init(L)
	# L = [16, 14, 6, 5, 1, 7, 10, 4, 15, 9, 2, 12, 11, 13, 3, 8] 
	# L = merge_sort_init(L,2)
	if is_sorted(L) == 1: print("Eine Liste wurde erfolgreich sortiert")
	else: print("!!! ERROR !!!")
print()

# Aufgabenteil d

def merge_sort(L,threshold=9):
	'''Sortiert die Liste L mit Mergesort. Optional, kann angegeben werden, ab welchem threshold Bubble-Sort benutzt werden soll.'''
	len_L = len(L)
	size = min(threshold,len_L)
	#sortiere die Teillisten
	for lo in [i*size for i in range(round(len_L/size+.5))]:
		up = min(lo+size,len_L)
		# print("SORTING:\nlength: %s, lo: %s, up: %s" % (size,lo,up))
		# print(" L: %s \n  ->" % (L) )
		bubble_sort(L,lo,up)
		# print(" L: %s \n" % (L) )
	#merge die Teillisten
	while size < len_L:
		H = L[:] #H updaten
		for lo in [i*2*size for i in range(round(len_L/(2*size)+.5))]:
			mid = lo+size
			up = min(lo+2*size,len_L)
			# print("MERGING:\nlength: %s, lo: %s, up: %s, mid: %s" % (size,lo,up,mid))
			# print(" L: %s \n H: %s \n  ->" % (L,H) )
			merge(L,H,lo,up,mid)
			# print(" H: %s \n" % (H) )
			L = H[:] #L updaten
		size *= 2
	return L


# Tests
for i in range(10):
	L = generate_random_list(0,20,16)
	L = merge_sort(L)
	# L = [16, 14, 6, 5, 1, 7, 10, 4, 15, 9, 2, 12, 11, 13, 3, 8] 
	# L = merge_sort(L,2)
	if is_sorted(L) == 1: print("Eine Liste wurde erfolgreich sortiert")
	else: print("!!! ERROR !!!")
