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
print("\n")

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

def merge_sort(L,H,lo,up,length):
	if length <= 9:
		bubble_sort(L,lo,up)
	else:
		merged = 0 #gibt an bis wohin H gemerged wurde
		while merged < len(H):
			lo = merged
			up = min(len(H),merged+2*length)
			mid = min(len(H),merged+length)
			merge_sort(L,H,lo,mid,length)
			merge_sort(L,H,mid,up,length)
			merge(L,H,merged,lo,up,mid)
			merged += 2*length
		L = H[:] #L updaten
		length *= 2 #nächte mergestufe

def merge_sort_init(L):
	H = L[:]
	if len(L) < 9:
		bubble_sort(L,0,len(L))
	else:
		length = min(9,len(L)//2) #gibt die Länge der zu mergenden Listen an
		merge_sort(L,H,0,len(L),length)

# Tests
for i in range(10):
	L = generate_random_list()
	merge_sort_init(L)
	print(L)
	if is_sorted(L) == 1: print("List was sorted Successfully")
	else: print("!!! ERROR !!!")

# Aufgabenteil d













