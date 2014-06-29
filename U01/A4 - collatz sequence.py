def collatz(n):
	'''gibt eine Liste der Zahlen der Collatz Folge startend von einer gegebenen ganzen Zahl zurück'''
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
	'''gibt eine Liste aus, welche Listen der Zahlen Collatz Folgen mit startwerten zwischen 1 und einer gegebenen ganzen Zahl ausgibt'''
	col_n_list = []
	for i in range(1,n+1):
		col_n_list += [collatz(i)]
	return col_n_list

def print_collatz(col_n_list):
	'''printed das Ergebnis von collatz_seqs übersichtlich'''
	for i in range(len(col_n_list)):
		print(i+1,":\t",col_n_list[i])

# Test
print(collatz(12))
print(collatz(25))
print_collatz(collatz_seqs(3))
print_collatz(collatz_seqs(12))
print_collatz(collatz_seqs(25))