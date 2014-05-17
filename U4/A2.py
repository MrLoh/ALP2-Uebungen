def bubble_sort(L):
	'''Sortiert die gegebene Liste L mit Bubble-Sort.'''
	remain = len(L)-1
	done = False
	swap_counter = [ [] for i in range(len(L)) ]
	while not done:
		done = True
		for i in range(remain):
			if L[i] > L[i+1]:
				done = False
				# print("Swapping %s_%s and %s_%s" % (L[i],i,L[i+1],i+1))
				L[i], L[i+1] = L[i+1], L[i]
				swap_counter[i] += [1]
				swap_counter[i+1] += [-1]
				swap_counter[i], swap_counter[i+1] = swap_counter[i+1], swap_counter[i]
		remain -= 1
	print("Es wurden %s verschlechternde Vertauschungen ausgeführt." % sum([ abs(abs(sum(swap_counter[i]))-len(swap_counter[i])) for i in range(len(swap_counter)) ]) )

# Test
from random import randint
for i in range(10):
	L = [ randint(0,99) for i in range(20) ]
	bubble_sort(L)