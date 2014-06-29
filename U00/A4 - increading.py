a = int(raw_input("gimme an int: "))
b = int(raw_input("gimme an int: "))
c = int(raw_input("gimme an int: "))

ints = "a = %s, b = %s, c = %s" % (a,b,c)

if a>b and b>c:
	print "die zahlen "+ints+" sind streng absteigend."
elif a<b and b<c:
	print "die zahlen "+ints+" sind streng aufsteigend."
else
	print "die zahlen "+ints+" sind weder streng auf- noch absteigend."