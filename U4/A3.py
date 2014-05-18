# Aufgabenteil a)
def counting_sort(L):
	'''Sortiert die gegebene Liste von ganzen Zahlen mit in-place Counting-Sort.'''
	C = [0 for i in range(max(L)+1)]
	for i in range(len(L)):
		C[L[i]] += 1
	l_i = 0
	for c_i in range(len(C)):
		while C[c_i] != 0:
			L[l_i] = c_i
			l_i += 1
			C[c_i] -= 1

# Tests
from random import randint
for i in range(10):
	L = [ randint(0,9) for i in range(20) ]
	counting_sort(L)
	print(L)
print()

# Aufgabenteil c)
from textwrap import fill as wrap_text
print(wrap_text("Der Algorythmus besteht aus zwei Teilen. Zunächst werden alle Elemente von L aufgerufen und in C summiert. Dabei ist die Laufzeit T1=c1*n wobei n=len(L). Danach werden alle addierten einsen aus C n=sum(C)=len(L) wieder in L abgespeichert T2=c2*n. Allerdings muss in diesem Schritt auch noch mindestens m=len(C)=max(L) mal verglichen werden, ob das Element von C bereits 0 ist. Damit ergibt sich T3=c3*m. Insgesamt haben wir damit eine Laufzeit von T=(c1+c2)*n+c3*m=O(n+m)."))
print()
print(wrap_text("Der Speicheraufwand ist durch die Länge von C, also den Betrag des größten Elements von L, m=len(C)=max(L) gegeben S(m)=c1*m=O(m)."))
print()

# Aufgabenteil b)
print(wrap_text("Der in-place Counting-Sort Algorythmus ist nicht zum sortieren nach Geburtstagen geeignet. Es treten zwei Probleme auf:"))
print(wrap_text("1. kann der Algorythmus nur Listen aus ganzen Zahlen sortieren, da die gegebene Liste mit den in C gespeicherten Plätzen überschrieben wird. C speichert aber nur Positionen von ganzen Zahlen und keine Daten. Dies lässt sich nur lösen, wenn die in-place Eigenschaft aufgegeben wird."))
print(wrap_text("2. Außerdem ist der Algorythmus noch nicht einmal zur Sortierung von Geburtsdaten an sich geeignet. Geburtstage sind 8-stellige Zahlen (YYYMMDD), somit bräuchte man eine über 20-millionen-stellige Hilfsliste C und selbst, wenn man den Algorythmus so verändern würde, dass C nicht bei 0 losläuft sondern einen Startwert akzeptiert, so hätte man immernoch 1 Million Stellen in C für die letzten hundert Jahre und proportionale Laufzeit und Speicherverbrauch. Die Lösung wäre eine Radix-Sort-Variante, welche nacheinander Tage, Monate und Jahre sortiert. Diese lässt sich mit diesem Algorythmus aber wegen der fehlenden Stabilität nich implementieren. "))



