public class TestIntervall {
	public static void main(String[] args) {
		Intervall i1 = new Intervall(1,5);
		Intervall i2 = new Intervall(-3,3);
		Intervall i3 = new Intervall(-3,-1);
		Intervall i4 = new Intervall(5,10);
		Intervall i5 = new Intervall(8,10);
		Intervall iempty = new Intervall(6,5);

		// Test enthaelt
		System.out.println(String.format("2.0 in %s?",i1));
		System.out.println(i1.enthaelt(2));
		System.out.println(String.format("1.0 in %s?",i1));
		System.out.println(i1.enthaelt(1));
		System.out.println(String.format("8.0 in %s?",i1));
		System.out.println(i1.enthaelt(8));
		System.out.println(String.format("2.0 in %s?",iempty));
		System.out.println(iempty.enthaelt(2));
		System.out.println();

		// Test schneidet
		System.out.println(String.format("%s schneidet %s?",i1,i4));
		System.out.println(i1.schneidet(i4));
		System.out.println(String.format("%s schneidet %s?",i4,i1));
		System.out.println(i4.schneidet(i1));
		System.out.println(String.format("%s schneidet %s?",i1,i5));
		System.out.println(i1.schneidet(i5));
		System.out.println(String.format("%s schneidet %s?",iempty,i1));
		System.out.println(iempty.schneidet(i1));
		System.out.println(String.format("%s schneidet %s?",i1,iempty));
		System.out.println(i1.schneidet(iempty));
		System.out.println();

		// Test beinhaltet
		System.out.println(String.format("%s beinhaltet %s?",i2,i3));
		System.out.println(i2.beinhaltet(i3));
		System.out.println(String.format("%s beinhaltet %s?",i3,i2));
		System.out.println(i3.beinhaltet(i2));
		System.out.println(String.format("%s beinhaltet %s?",i2,i1));
		System.out.println(i2.beinhaltet(i1));
		System.out.println(String.format("%s beinhaltet %s?",i2,iempty));
		System.out.println(i2.beinhaltet(iempty));
		System.out.println();

		// Test laenge
		System.out.println(i1);
		System.out.println(String.format("laenge: %s",i1.laenge()));
		System.out.println(i3);
		System.out.println(String.format("laenge: %s",i3.laenge()));
		System.out.println(iempty);
		System.out.println(String.format("laenge: %s",iempty.laenge()));
	}
}
