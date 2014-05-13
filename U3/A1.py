def quick_sort(L,lo,up): 
	def partition(L,lo,up):
		p = L[lo]
		p_i = lo
		for j in range(lo+1,up+1):
			if L[j] < p: 
				p_i += 1
				L[p_i],L[j] = L[j],L[p_i] 
		L[p_i],L[lo] = L[lo],L[p_i]
		return p_i
	if lo < up:
		p_i = partition(L,lo,up)
		quick_sort(L,lo,p_i-1)
		quick_sort(L,p_i+1,up)

def quick_sort_helper(L):
	quick_sort(L,0,len(L)-1)
	return L

def quick_sort_stable(L): 
	if len(L) <= 1:
		return L
	else:
		Lu = quick_sort_stable([ el for el in L[1:] if el<L[0] ])
		Lo = quick_sort_stable([ el for el in L[1:] if el>=L[0] ])
		return Lu + [L[0]] + Lo

L1 = [2,4,6,8,3,2,8,5,3,7,9,1] 
L2 = [(1,"a"),(2,"a"),(1,"b"),(3,"a"),(1,"d")]

for L in [L1,L2]:
	print(L)
	# L = quick_sort_stable(L)
	L = quick_sort_helper(L)
	print(L)
	print("\n")

for L in [L1,L2]:
	print(L)
	L = quick_sort_stable(L)
	# quick_sort(L,0,len(L))
	print(L)
	print("\n")

