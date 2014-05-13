def quick_sort(L): 
	if len(L) <= 1:
		return L
	else:
		Lu = quick_sort([el for el in L[1:] if el<L[0]])
		Lo = quick_sort([el for el in L[1:] if el>=L[0]])
		return Lu + [L[0]] + Lo

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

def merge_sort(L):
	