def collatz(n):
	col_list = [n]
	while n > 1:
		if n%2 == 0:
			n = n/2
			col_list += [n]
		else:
			n = n*3+1
			col_list += [n]
	return col_list 

def collatz_seqs(n):
	col_n_list = []
	for i in range(1,n+1):
		col_n_list += [collatz(i)]
	return col_n_list

def print_collatz(col_n_list):
	for i in range(len(col_n_list)):
		print(i+1,":\t",col_n_list[i])

print_collatz(collatz_seqs(12))