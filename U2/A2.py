from time import time

def zip_with_rekur(f,xs,ys):
	'''Gegeben eine funtion f, und zwei listen xs und ys, mit |xs|<=|ys|, wird eine Liste aller f(x_i,y_i) zurück, für die x_i,y_i in xs,ys. Die Methode ist rekursiv umgesetzt.'''
	if len(xs) == 1:
		return [f(xs[0],ys[0])]
	else:
		return [f(xs[0],ys[0])] + zip_with_rekur(f,xs[1:],ys[1:])

def zip_with_iter(f,xs,ys):
	'''Gegeben eine funtion f, und zwei listen xs und ys, mit |xs|<=|ys|, wird eine Liste aller f(x_i,y_i) zurück, für die x_i,y_i in xs,ys. Die Methode ist iterativ umgesetzt.'''
	for i in range(len(xs)):
		xs[i] = f(xs[i],ys[i])
	return xs

# Test
def sum(x,y):
	return x+y
xs=[1,2,3,4]
ys=[10,10,20,20]

t1 = time()
print(zip_with_rekur(sum,xs,ys))
t2 = time()
dt_rekur = float(t2-t1)
print('runtime: %sms' % str(dt_rekur*1000)[0:4])
t1 = time()
print(zip_with_iter(sum,xs,ys))
t2 = time()
dt_iter = float(t2-t1)
print('runtime: %sms' % str(dt_iter*1000)[0:4])

print('Die iterative umsetzung der zipWith funktion ist %s mal schneller, als die rekursive.' % str(dt_rekur/dt_iter)[0:5])