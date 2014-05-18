# Aufgabentail a)
def heapify(H,i):
	'''Stellt die Heapbedingung des Heaps H an der Stelle i her.'''
	le, ri = i*2, i*2+1
	if le <= H[0] and H[le][:2]>H[i][:2]: maxi = le
	elif ri <= H[0] and H[ri][:2]>H[i][:2]: maxi = ri
	else: maxi = i
	if maxi != i:
		H[i], H[maxi] = H[maxi], H[i]
		heapify(H,maxi)

def build_heap(H):
	'''Wandelt eine Liste L in einen Heap um, welcher zurückgegeben wird.'''
	H[0] = len(H)-1
	for i in range(H[0]//2,0,-1):
		heapify(H,i)

def heapsort(H):
	'''Sortiert die Liste L mit Heapsort und gibt die Liste zurück.'''
	build_heap(H)
	for i in range(H[0],1,-1):
		H[i], H[1] = H[1], H[i]
		H[0] -= 1
		heapify(H,1)
	H[0] -= 1
	return H[1:]

print("Heapsort ist nicht stabil, wie man an folgendem Beispiel sehen kann.")
H = ["",(2,2,"a"),(2,2,"b"),(1,1,"a")]
print(" H: ",H[1:])
print("Der Heap wird nach den ersten beiden Tupelelementen sortiert. ")
print(" H: ",heapsort(H))
print("Die Ursprüngliche Reihenfolge von (2,2,a) und (2,2,b) wurde vertauscht.")
print()

# Aufgabentail b)
from random import randint
from time import time
def next_message():
	return (randint(1,50),time(),"Message:%06d" % randint(0,999999))
	# yield is not possible, because it produces a TypeError with the message " 'generator' object is not subscriptable ". We would have to create a class to really use yield in a meaningfull way here. 

# Aufgabentail c)
def insert(message_queue,message):
	'''Eine neue Nachricht wird in die Prioritätswarteschlange eingefügt.'''
	message_queue[0] += 1 #Heaplgröße erhöhen
	message_queue.insert(1,message) #neue Wurzel hinzufügen
	heapify(message_queue,1) #Heapeigenschaft wiederherstellen
	# print("INSERTED MESSAGE:")
	return message

def is_empty(message_queue):
	'''gibt einen Wahrheitswert als Rückgabewert zurück, je nachdem, ob die Prioritätswarteschlange leer ist oder nicht.'''
	return (True if message_queue[0] == 0 else False)

def remove_message(message_queue):
	'''Die Nachricht mit der höchsten Priorität und die, die zeitlich zu erst produziert worden ist, wird aus der Prioritätswarteschlange entfernt und als Ergebnis der Funktion zurückgegeben.'''
	if is_empty(message_queue):
		return None
	else:
		message_queue[0] -= 1 #Heaplgröße veringern
		message = message_queue.pop(1) #Wurzel entfernen
		heapify(message_queue,1) #Heapeigenschaft wiederherstellen
		# print("REMOVED MESSAGE:")
		return message

def sort_messages(message_queue):
	'''Erstellt einen Heap aus der gegebenen message_queue.'''
	build_heap(message_queue)

# Aufgabentail d)
def simulate_message_traffic(N=50):
	'''Simuliert zufälligen Nachrichten Austausch.'''
	message_queue = [0]
	for i in range(N):
		# print("QUEUE: ",message_queue)
		if randint(0,1) == 1:
			insert(message_queue,next_message())
		else: 
			print(remove_message(message_queue))

simulate_message_traffic()
