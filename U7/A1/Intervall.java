public class Intervall {

	// attributes
	public double a;
	public double b;
	private boolean empty = false;

	// constructors
	public Intervall (double a, double b) {
		if( a < b ) {
			this.a = a;
			this.b = b;
		} else {
			this.empty = true;
		}
	}

	// methods
	public boolean enthaelt(double x) {
		// ueberprueft, ob x im Intervall ist
		return !this.empty && (this.a <= x && x <= this.b);
	}
	public boolean schneidet(Intervall cd) {
		// ein Intervall-Objekt ueberprueft, ob es sich mit einem zweiten Intervall-Object cd schneidet.
		return !this.empty && ( (cd.a <= this.a && cd.b >= this.a) || (cd.a >= this.a && cd.a <= this.b) );
	}
	public boolean beinhaltet(Intervall cd) {
		// ein Intervall-Objekt testet, ob es das eingegebene Intervall cd vollstaendig beinhaltet.
		return !this.empty && (cd.a >= this.a && cd.b <= this.b);
	}
	public double laenge() {
		// berechnet die Laenge des Intervalls.
		if( !this.empty ) {
			return this.b-this.a;
		} else {
			return 0;
		}
	}
	public String toString() {
		// das Intervall soll als Text dargestellt werden.
		if( !this.empty ){
			return String.format("Intervall [%s, %s]", this.a, this.b);
		} else {
			return "Intervall EMPTY";
		}
	}
}
