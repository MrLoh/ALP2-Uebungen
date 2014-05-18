from textwrap import fill as wrap_text
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
	total_swaps = sum([ len(swaps) for swaps in swap_counter ])
	wrong_direction_swaps = sum([ abs( abs(sum(swaps))-len(swaps) ) for swaps in swap_counter ])//2
	print(wrap_text( "Von %d Vertauschungen, gingen %d in die falsche Richtung und nochmal soviele wurden gebraucht um diese Rückgängig zu machen. Insgesamt waren also %d%% der Vertauschungen unnötig" % (total_swaps,wrong_direction_swaps,round(2*wrong_direction_swaps/total_swaps*100)) ),"\n")
	return 2*wrong_direction_swaps/total_swaps*100

# Test
from random import randint
for i in range(10):
	L = [ randint(0,99) for i in range(100) ]
	unuseful_swap = []
	unuseful_swap += [bubble_sort(L)]
	unuseful_swap_average = sum(unuseful_swap)/len(unuseful_swap)
	print("Durchschnittlich waren %.2f%% der Vertauschungen unnötig." % unuseful_swap_average)
