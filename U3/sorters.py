# QUICK SORT

def quick_sort_stabel(L): 
	if len(L) <= 1:
		return L
	else:
		Lu = quick_sort([ el for el in L[1:] if el<L[0] ])
		Lo = quick_sort([ el for el in L[1:] if el>=L[0] ])
		return Lu + [L[0]] + Lo

def quick_sort(L,lo=0,up=len(L)): 
	def partition(L,lo,up):
		pivot = L[lo]
		i = lo
		for j in range(lo+1,up+1):
			if L[j] < pivot: 
				i += 1
				L[i],L[j] = L[j],L[i] 
		L[i],L[lo] = L[lo],L[i]
		return i
	if lo < up:
		m = partition(L,lo,up)
		quicksort(L,lo,m-1)
		quicksort(L,m+1,up)



# BUBBLE SORT

def bubble_sort(L):
	stop = len(L)
	done = False
	while not done:
		done = True
		for i in range(stop):
			if L[i]>L[i+1]:
				done = False
				L[i], L[i+1] = L[i+1], L[i]
		stop -= 1

# MERGE SORT

def merge(lo,up):
	res = []
	i,j = 0,0
	while i < len(lo) and j < len(up):
		if lo[i] <= up[j]: 
			res += [lo[i]]
			i += 1 
		else:
			res += [up[j]]
			j += 1 
		res += lo[i:]
		res += up[j:]

def merge_sort(L):
	if len(A) < 2:
		return L 
	else:
		m = len(A) // 2
		return merge(merge_sort(A[:m]),merge_sort(A[m:]))


# HEAP SORT

def heapify(H,i):
	'''Stellt die Heapbedingung des Heaps H an der Stelle i her.'''
	le, ri = i*2, i*2+1
	if le <= H[0] and H[le]>H[i]: maxi = le
	elif ri <= H[0] and H[ri]>H[i]: maxi = ri
	else: maxi = i
	if maxi != i:
		H[i], H[maxi] = H[maxi], H[i]
		heapify(H,maxi)

def build_heap(L):
	'''Wandelt eine Liste L in einen Heap um.'''
	L = [len(L)]+L[:]
	for i in range(L[0]//2,0,-1):
		heapify(L,i)

def heapsort(L):
	'''Sortiert die Liste L mit Heapsort und gibt die Liste zurück.'''
	build_heap(L)
	for i in range(L[0],1,-1):
		L[i], L[1] = L[1], L[i]
		L[0] -= 1
		heapify(L,1)









