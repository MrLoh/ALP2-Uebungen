Methoden sollten als Klassenmethoden (static) definiert werden, wenn sie keine Instanzvariablen verändert oder benutzt. Insbesondere, wenn sie nur auf ihren Parametern agieren, wenn die Klasse keine Instanzvariablen hat oder wenn sie nur auf Klassenvariablen agiert. 

Lokale Variablen sind automatisch privat, ihr Skope ist immer nur die Methode bzw. der Block in dem sie deklariert werden. Es macht Sinn Klassenmethoden als privat zu deklarieren, wenn sie nur als Hilfsmethoden für andere Methoden der Klasse agieren und wenn sie private Variablen exposen könnten. 

Wenn in einer Klassendefinition kein Konstruktor existiert, wird automatisch ein leerer Konstruktor aufgerufen, welcher die Instanzvariablen mit den Defaultwerten bzw. ohne Werte initialisiert. 
Konstruktoren können nur explizit vererbet werden, indem `super` im Konstruktor der Unterklasse aufgerufen wird.
Konstruktoren können privat sein, dies macht Sinn für Klassen, welche nur Klassenmethoden und oder Konstanten sammeln und, wenn meherer Konstruktoren oder Factory Methoden verwendet werden. 

Die Main Methode muss eine Klassenmethode sein, da sie direkt in der JVM aufgerufen wird, ohne das zuvor ein Objekt erzeugt werden musste. Schließlich können nur in der Main Methode Objekte erzeugt werden, also nicht bevor sie aufgerufen wurde. Wenn die Main Methode nicht statisch ist, gibt das Programm einen Fehler aus. 

Als `protected` deklariert Instanzvariablen sind sichtbar in der Klasse, in Unterklassen und im Package. Konstruktoren können als `protected` deklariert werden, wenn Objekte des entsprechenden Typs nicht außerhalb des Packages erzeugt werden sollen. 

Abstrakte Klassen sind Klassen, von denen keine Objekte erstellt werden können. Sie dienen dazu Methoden und Variablen in einer Klasse zusammen zu fassen, welche entweder nur statisch sind oder von Unterklassen geerbt werden sollen. Klassenmethoden und Klassenvariablen von abstrakten Klassen können aufgerufen werden als `Class.var` bzw. `Class.CONST` bzw. `Class.method(pars)`. 

Objekte abstrakter Klassen können zwar nicht erzeugt werden, es macht aber trotzdem unter Umständen Sinn einen Konstruktor in ihnen zu definieren, wenn dieser von den Unterklassen geerbt werden soll. 

Schnittstellen definieren Variablen und Methoden, die von bestimmten Klassen implementiert werden sollen. Damit bieten sie eine Möglichkeit gewisse Funktionalitäten von Klassen zusammen zu fassen und sicherzustellen, dass diese für alle Klassen, welche das Interface implementieren aufrufbar sind.

Es ist keine gute Idee in einer Elternklasse Instanzvariablen vom Typ von Kinderklassen zu definieren, da dies zu einer Endlosschleife beim Erzeugen von Objekten der Eleternklasse führt, denn der Konstruktor ruft den Konstruktor der Kindklasse auf, welche wiederum den Konstruktor der Elternklasse aufruft und so weiter. 

Methodenüberladung bedeutet, dass eine Methode mehrmals mit demselben Namen und verschiedenen Argumenten definiert wird. Beim aufrufen wird dann automatisch die Implementierung mit den passenden Argumenten aufgerufen. Methodenüberschreibung bedeutet, dass eine Methode der Elternklasse in der Kindklasse neu definiert wird. In diesem Fall kann auf Objekten der Kindklasse nur noch die überschriebene Methode aufgerufen werden. 

Variablen können in Unterklassen nicht überschrieben werden, nur versteckt. Das heißt, wenn die Variable neu in der Unterklasse definiert wird, so gilt sie zwar in den in der Unterklasse neu definierten Methoden, nicht aber in den Methoden, welche von der Oberklasse geerbt wurden. 

Da in Java primitive Datentypen keine Objekte sind, manche Strukturen wie zum Beispiel Arrays und Enumeratoren aber nur mit Objekten gebaut werden können, gibt es Wrapper Klassen für die primitiven Datentypen. Die Operationen für primitive Datentypen funktionieren auch noch für Objekte der Wrapper Klasse. Dabei werden die Wrapper zunächst ausgepackt, dann die Operation ausgeführt und dann das Reslutat wieder in Wrapper verpackt. Das Auspacken funktioniert allerding nur bei Objekten, die mit automatischen Einpacken gebildet wurden und nur innerhalb des Wertbereichs -128 bis 127. Dies kann zu großen Verwirrungen führen. 

Generische Klassen sind Klassen, welche es ermöglichen eine ganze Familie von Klassen auf einmal zu definieren. Sie haben ein Objekttyp als Argument, welcher in der Klasse verwendet wird und können dann mit verschiedene Objekttypen initialisiert werden. 

Vererbungspolymorphie bedeutet, dass Objekte von einer Klasse auch immer vom Typ aller Oberklassen und Schnittsetellen dieser Klasse sind. 

Exceptions (Ausnahmefehler) sind unerwartete Fälle, auf welche das Programm reagieren muss. In Java sind Exceptions als Objekte implementiert, welche vom Exception Objekt erben. Methoden können Exception Objekte werfen. Wenn eine Methode Exceptions wirft, so müssen diese aufgefangen werden. Runtime-Exceptions sind Exceptions, welche von der `RuntimeException` Klasse erben. Sie sind insofern besonders, als sie nicht aufgefangen werden müssen. 





