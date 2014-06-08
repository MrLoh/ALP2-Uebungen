public class IEEE_Test {
	public static void main(String[] args) {
	// Rechnen mit Floating Points
		double x = 1.0;
		double y = 0.0;
		double z = Double.POSITIVE_INFINITY;
		System.out.println(y/x);
		// => 0.0
		// 0/1=0, der Typ bleibt Double
		System.out.println((x/y+x/y));
		// => Infinity
		// Unendlich kann adiert werden und bleibt unendlich
		System.out.println((x/y-x/y));
		// => NaN (= not a number)
		// Auf Unendlich ist keine Differenz definiert.
		System.out.println(y/y);
		// => NaN
		// Divisiion ist nicht auf Unendlichkeiten definiert.
		System.out.println(z/z);
		// => NaN
		// Divisiion ist nicht auf Unendlichkeiten definiert.

	// Rechnen mit Integers
		int m = 3;
		int n = 1;
		System.out.println(x/m);
		// => 0.3333333333333333
		// Integer werden bei nicht ganzzahligem Ergebnis einer Division zu Doubles.
		System.out.println(n/m);
		// => 0
		// Integer bleiben bei ganzzahligem Ergebnis einer Division Integer.

	// Maxima und Minima von Zahlen
		int max = 2147483647;
		int min = -2147483648;
		System.out.println(max+1);
		// => -2147483648
		System.out.println(min-1);
		// => 2147483647
		System.out.println((max+1)==(min));
		// => true
		// 32 bit Integer reichen von -2^31 bis 2^31-1. Wenn sie aus dem Wertebereich laufen, fangen sie oben/unten wieder an, daher ist max+1==min.
		System.out.println(Double.MAX_VALUE*2);
		// => Infinity
		// Der Maximalwert von Doubles ist Infinity. 2 mal unendlich bleibt unendlich.

	// Mathematische Funktionen
		System.out.println(Math.sqrt(-x));
		// => NaN
		// Java kann nicht in Komplexe Zahlen umrechnen.
		System.out.println(Math.log(-x));
		// => NaN
		// Der Logarithmus von negativen Zahlen ist nicht definiert.

	// Bit Operationen
		System.out.println(3|4);
		// => 7
		// | ist ein Bitweise oder. 3_10|4_10 = 011_2|100_2 = 111_2 = 7_10.
		System.out.println(~5);
		// => -6
		// ~ ist eine Bitweise negation ~a = -a-1.
		System.out.println(2^2^3);
		// => 3
		// ^ ist ein Bitweise exklusives oder. 10^10^11 = 00^11 = 11

	// Bool Operationen
		System.out.println(true || 12%3 == 1);
		// => true
		// true or false = true
		System.out.println(1<2 && 1<0);
		// => false
		// true and false = false
		System.out.println(true? 8 : 7);
		// => 8
		// Der Ternary Operator 'condition? a : b' ist a, wenn condition true ist, sonst ist er b.
	}
}
