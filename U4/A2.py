# def bubble_sort(L):
# 	'''Sortiert die gegebene Liste L mit Bubble-Sort.'''
# 	remain = len(L)-1
# 	done = False
# 	while not done:
# 		done = True
# 		for i in range(remain):
# 			if L[i] > L[i+1]:
# 				done = False
# 				L[i], L[i+1] = L[i+1], L[i]
# 		remain -= 1


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


L = [8,15,16,9,13,12,5,4,3,11,14,1,2,10,7,6,11,20,19,17,18]
print(L)
bubble_sort(L,0,len(L))
print(L)