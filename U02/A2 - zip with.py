from time import time

def zip_with_rekur(f,xs,ys):
	'''Gegeben eine funtion f, und zwei listen xs und ys wird eine Liste aller f(x_i,y_i) zurück, für die x_i,y_i in xs,ys. Die Methode ist rekursiv umgesetzt.'''
	if min(len(xs),len(ys)) == 0:
		return []
	else:
		return [f(xs[0],ys[0])] + zip_with_rekur(f,xs[1:],ys[1:])

def zip_with_iter(f,xs,ys):
	'''Gegeben eine funtion f, und zwei listen xs und ys, wird eine Liste aller f(x_i,y_i) zurück, für die x_i,y_i in xs,ys. Die Methode ist iterativ umgesetzt.'''
	return [f(xs[i],ys[i]) for i in range(min(len(xs),len(ys)))]

# Test
def sum(x,y):
	return x+y
xs=[1,2,3,4]
ys=[10,10,20,20]

t1 = time()
print(zip_with_rekur(sum,xs,ys))
t2 = time()
dt_rekur = float(t2-t1)
print('runtime: %.3fms' % (dt_rekur*1000))
t1 = time()
print(zip_with_iter(sum,xs,ys))
t2 = time()
dt_iter = float(t2-t1)
print('runtime: %.3fms' % (dt_iter*1000))

print('Die iterative umsetzung der zipWith funktion war %.1f mal schneller, als die rekursive.' % (dt_rekur/dt_iter))