from operator import itemgetter

def identity(a):
	return a

def quick_sort(L,lo,up,key): 
	def partition(L,lo,up):
		p = L[lo]
		p_i = lo
		for j in range(lo+1,up+1):
			if key(L[j]) < key(p): 
				p_i += 1
				L[p_i],L[j] = L[j],L[p_i] 
		L[p_i],L[lo] = L[lo],L[p_i]
		return p_i
	if lo < up:
		p_i = partition(L,lo,up)
		quick_sort(L,lo,p_i-1,key)
		quick_sort(L,p_i+1,up,key)

def quick_sort_helper(L,key=identity):
	quick_sort(L,0,len(L)-1,key)
	return L

def quick_sort_stable(L,key=identity): 
	if len(L) <= 1:
		return L
	else:
		Lu = quick_sort_stable([ el for el in L[1:] if key(el)<key(L[0]) ],key)
		Lo = quick_sort_stable([ el for el in L[1:] if key(el)>=key(L[0]) ],key)
		return Lu + [L[0]] + Lo

L = [1,2,1,3,1] 
print(L)
quick_sort_helper(L)
print(L)
print()

L = [(1,"a"),(2,"a"),(1,"b"),(3,"a"),(1,"c")]
print(L)
print("in-place quick sort:\n",quick_sort_helper(L[:],itemgetter(0)))
print("stable quick sort:\n",quick_sort_stable(L[:],itemgetter(0)))