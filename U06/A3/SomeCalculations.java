import java.util.Random;

public class SomeCalculations {
	//Aufgabenteil a)
	public static int querSumme(int n) {
		if( n<=9 ) {
			return n;
		}
		return n%10 + querSumme(n/10);
	}

	public static boolean multipleOf3(int n) {
		if( (querSumme(n)%3 == 0) && (n%3 == 0) ) {
			return true;
		}
		return false;
	}

	//Aufgabenteil b)
	public static int weekday(int year, int month, int day) {
		int y0 = year - (14-month)/12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = month + 12*((14-month)/12)-2;
		return (day + x + 31*m0/12)%7;
	}

	//Aufgabenteil c)
	public static void printIntAsDollardigns(int n) {
		int i = 0;
		String out = "";
		while( i <= n ) {
			out += "$";
			i++;
		}
		System.out.println(out);
	}

	public static int gluecksspieler(int bargeld) {
		Random rand = new Random();
		int limit = 2*bargeld;
		int numBets = 0;
		while( bargeld > 0 && bargeld < limit ) {
			numBets ++;
			if( rand.nextInt(2) == 0 ) {
				bargeld ++;
			}
			else {
				bargeld --;
			}
			printIntAsDollardigns(bargeld);
		}
		if( bargeld == 0 ) {
			System.out.println("alles verloren!");
		} else if( bargeld == limit ) {
			System.out.println("Einsatz verdoppelt!");
		}
		return numBets;
	}

	//Tests
	public static void main(String[] args) {
		//Aufgabenteil a)
		System.out.println(querSumme(12));
		System.out.println(querSumme(124));
		System.out.println(multipleOf3(12));
		System.out.println(multipleOf3(124));

		//Aufgabenteil b)
		System.out.println("Hib ein Jahr ein:");
		int year = Keyboard.readInt();
		// Jahre haben keinen eingeschraenkten Wertebereich
		System.out.println("Gib einen Monat ein:");
		int month = Keyboard.readInt();
		while( month > 12 || month < 1 ) {
			System.out.println("Eingabe nicht im Wertebereich zwischen 1 und 12, versuch es nochmal:");
			month = Keyboard.readInt();
		}
		System.out.println("Gib einen Tag ein:");
		int day = Keyboard.readInt();
		while( day > 31 || day < 1 ) {
			System.out.println("Eingabe nicht im Wertebereich zwischen 1 und 31, versuch es nochmal:");
			day = Keyboard.readInt();
		}
		System.out.println("Der Wochentag ist:");
		String dayName = "";
		switch( weekday(year,month,day) ) {
			case 0: dayName = "So"; break;
			case 1: dayName = "Mo"; break;
			case 2: dayName = "Di"; break;
			case 3: dayName = "Mi"; break;
			case 4: dayName = "Do"; break;
			case 5: dayName = "Fr"; break;
			case 6: dayName = "Sa"; break;
		}
		System.out.println(dayName);

		//Aufgabenteil c)
		gluecksspieler(10);
	}
}
