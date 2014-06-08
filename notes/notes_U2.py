import time
def runtime(m,f,xs):
	t1 = time.time()
	m(f,xs)
	t2 = time.time()
	return t2-t1


def plus(n):
	return n+1

def map_rek(f,xs):
	if len(xs) > 0:
		return [f(xs[0])] + map_rek(f,xs[1:])
	else:
		return []

def map_endrek(f,xs,akk=[]):
	if len(xs)>0:
		akk += [f(xs[0])]
		return  map_endrek(f,xs[1:],akk)
	else:
		return akk

def map_iter(f,xs):
	for i in range(len(xs)):
		xs[i] = f(xs[i])
	return xs

def map_enditer(f,xs):
	res = []
	for x in xs:
		res += [f(x)]
	return res

xs = list(range(5))
print(map_rek(plus,xs))
print(map_endrek(plus,xs))
print(map_iter(plus,xs))
print(map_enditer(plus,xs))

xs = list(range(1000))
print(runtime(map_rek,f,xs))
print(runtime(map_endrek,f,xs))
print(runtime(map_iter,f,xs))
print(runtime(map_enditer,f,xs))