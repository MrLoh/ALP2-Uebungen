# def merge(Lo,Lu):
# 	res = []
# 	i,j = 0,0
# 	while i < len(Lo) and j < len(Lu):
# 		if Lo[i] <= Lu[j]: 
# 			res += [Lo[i]]
# 			i += 1 
# 		else:
# 			res += [Lu[j]]
# 			j += 1 
# 	res += Lo[i:]
# 	res += Lu[j:]


# def merge_sort(L,lo,up):
# 	if len(L) <= 9:
# 		bubble_sort(L,lo,up)
# 		return L 
# 	else:
# 		mid = len(L)//2
# 		Lo = L[:mid]
# 		Lu = L[mid:]
# 		if len(Lo) <= 9: Lo = bubble_sort(Lo)
# 		else: Lo = merge_sort(Lo)
# 		if len(Lu) <= 9: Lo = bubble_sort(Lu)
# 		else: Lu = merge_sort(Lu)
# 		return merge(Lo,Lu)


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

L = [0, 1, 4, 5, 6, 6, 16, 17, 1, 4, 5, 5, 6, 6, 7, 15] 
H = L[:]
print(L)
merge(L,H,0,16,8)
L = H[:]
print(L)










