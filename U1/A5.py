import sys

def print_char_picture(decide_char_func):
	size = 48
	for i in range(0,size):
		for j in range(0,size):
			sys.stdout.write( decide_char_func(j,i,size) )
		print()

def diagonal(x,y,size):
	if x==y:
		return '@'
	else:
		return '.'

def grid(x,y,size):
	if (x%4==0) or (y%4==0):
		return '.'
	else:
		return ' '

def rect(x, y, size):
	viertel = size//4
	if x>=viertel and x<viertel*3 and y>=viertel and y<viertel*3:
		if (x>=y):
			return '0'
		else:
			return ' '
	else:
		if y>=(size//2):
			return chr(1)
		else:
			return '.'

def elipse(x,y,r):
	if 1 > ((x-r)/r)**2 + ((y-r)/r)**2: 
		return True
	else: 
		return False

def easter_egg(x,y,size):
	r = size/2
	if y < r:
		if elipse(x,y,r):
			if (x%4==0) and (y%4==0):
				return 'o'
			else: 
				return '_'
		else: 
			return ' '
	else:
		if elipse(x,y,r):
			if x%5==0 or x%5==1+3:
				return '|'
			else:
				return '⌷'
		else:
			return '.'

def chessboard(x,y,size):
	if y%12<6:
		if x%12<6:
			if (y%12==1 or y%12==4) and (x%12==1 or x%12==4):
				return ' '
			else: 
				return '⌷'
		else:
			return ' '
	else:
		if x%12>=6:
			if (y%12==1+6 or y%12==4+6) and (x%12==1+6 or x%12==4+6):
				return ' '
			else: 
				return '⌷'
		else:
			return ' '

# print_char_picture(diagonal)
# print_char_picture(grid)
# print_char_picture(rect)
print_char_picture(easter_egg)
print()
print_char_picture(chessboard)
