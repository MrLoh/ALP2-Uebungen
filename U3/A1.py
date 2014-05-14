# Aufgabenteil a)
from operator import itemgetter
def identity(a):
	return a

# Quicksort algorythmus aus der Vorlesung mit zusätzlichem key-Argument.
def quick_sort(L,lo,up,key): 
	'''Sortiert die Liste L zwischen den gegebenen Positionen lo und up. Dabei muss eine key-Funktion angegeben werden, welches das Element auswählt, nach dem sortiert werden soll.'''
	def partition(L,lo,up):
		p = L[lo]
		p_i = lo
		for j in range(lo+1,up+1):
			print("'%s'_%s < '%s'_%s => %s" % (L[j],j,p,lo,key(L[j]) < key(p)))
			if key(L[j]) < key(p): 
				p_i += 1
				L[p_i],L[j] = L[j],L[p_i] 
				print("Vertausche '%s'_%s und '%s'_%s => %s" % (L[p_i],p_i,L[j],j,L))
		L[p_i],L[lo] = L[lo],L[p_i]
		print("Vertausche '%s'_%s und '%s'_%s => %s" % (L[p_i],p_i,L[lo],lo,L))
		return p_i
	if lo < up:
		p_i = partition(L,lo,up)
		quick_sort(L,lo,p_i-1,key)
		quick_sort(L,p_i+1,up,key)

def quick_sort_helper(L,key=identity):
	'''Sortiert die komplette Liste L. Optional kann eine key-Funktion angegeben werden, welches das Element auswählt, nach dem sortiert werden soll.'''
	quick_sort(L,0,len(L)-1,key)
	return L

# Aufgabenteil a)
from textwrap import fill as break_lines
L = ["2a","3a","3b","1a"]
print(break_lines("Der in-place Quicksort Algorithmus aus der Vorlesung ist instabil. Nach außen hin gleiche Elemente der Liste behalten nach dem Sortieren nicht unbedingt ihre Ausgangsreihenfolge. Diese Eigenschaft kann ein Problem darstellen, wenn man strukturierte Daten nach verschiedenen Kriterien Sortieren will. Man betrachte beispielsweise die Liste %s, welche nach den Zahlen sortiert werden soll. Bei der Sortierung geschieht nun folgendes:" % L))
print("\nGegebene Liste: ",L)
print("=> Sortierte Liste: ",quick_sort_helper(L[:],itemgetter(0)),"\n")
print(break_lines("Man sieht, dass der Partitionsalgorythmus Element-3 zuerst mit Element-0 vergleicht und dann Element-3 mit Element-1 vertauscht, wodurch Element-2 und Element-1 nicht mehr die ursprüngliche Reihenfolge haben. Da diese sich aber nicht unterscheiden, werden sie nicht noch einmal vertauscht und das Endergebnis ist eine Liste, welche die Ursprüngliche Sortierung nicht bewahrt."))
print()

# Aufgabenteil b+c)
print(break_lines("Es besteht die Möglichkeit die Menge auf andere Art zu Partitionieren und somit einen stabilen Sortieralgorithmus zu erzeugen. Allerdings steigt dadurch der benötigte Speicher von O(log(n)) aud O(n), wobei n die Länge der Liste ist."))

def quick_sort_stable(L,key=identity): 
	if len(L) <= 1:
		return L
	else:
		Lu = quick_sort_stable([ el for el in L[1:] if key(el)<key(L[0]) ],key)
		Lo = quick_sort_stable([ el for el in L[1:] if key(el)>=key(L[0]) ],key)
		return Lu + [L[0]] + Lo

print(break_lines("Sortieren wir die obige Liste mit dem stabilen Quicksortalgorythmus nach dem ersten Tupel Element, so bleiben die im ersten Tupel gleichen Elemente in ihrere Ursprünglichen Reihenfolge:"))
print(quick_sort_stable(L[:],itemgetter(0)))
# Das eingeführte key-Argument und das obige Beispiel sind die Lösung für Aufgabenteil c). 
print()

# Aufgabenteil d)
print(break_lines("Das größte Element in einer Liste kann genau so häufig verschoben werden, wie es in der Liste vorkommt. Denn Quicksort sortiert die Liste immer von hinten nach vorne. Zuerst werden die größten, dann die kleineren Elemente and die richtige Position verschoben."))
from random import randint
for i in range(4):
	L = [ randint(1,9) for i in range(5) ]
	print("\nGegebene Liste: ",L)
	print("=> Sortierte Liste: ",quick_sort_helper(L[:]),"\n")