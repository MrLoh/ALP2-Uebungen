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
