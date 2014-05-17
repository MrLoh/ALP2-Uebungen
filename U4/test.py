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


def merge(L,H,lo,up):
	length = up-lo
	mid = lo+length//2
	print("mid = ",mid)
	i = lo
	j = mid
	for k in range(lo,up):
		print("k = ",k)
		if i < mid and j < up:
			print(L[i]," <= ",L[j]," = ",L[i]<=L[j])
			if L[i] <= L[j]:
				H[k] = L[i]
				print(H)
				i += 1
			else:
				H[k] = L[j]
				print(H)
				j += 1
		elif i < mid:
			H[k] = L[i]
			i += 1
		elif j < up:
			H[k] = L[j]
			j += 1

L = [0,9,9,1,3,5,7,9,0,2,4,6,8]
H = L[:]
print(L)
merge(H,L,3,13)
print(L)