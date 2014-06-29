import java.util.Random;

public class Gambler {

	// attributes
	private String name;
	private int id;
	private int startMoney;
	int currentMoney;
	int numBets;
	String gameProcess;

	// variables
	private static int nextId = 1;

	// constructors
	public Gambler(String name, int startMoney) {
		this.name = name;
		this.id = nextId;
		nextId ++;
		this.startMoney = startMoney;
		this.currentMoney = this.startMoney;
		this.numBets = 0;
		this.gameProcess = "";
	}
	private static String nextName() {
		return String.format("Gambler%s", nextId);
	}
	public Gambler(int startMoney) {
		this(nextName(), startMoney);
	}
	public Gambler() {
		this(25);
	}

	// standard methods
	public String toString() {
		return String.format("<Gambler> name: %s, start: %s$, current: %s$, plays: %s", this.name, this.startMoney, this.currentMoney, this.numBets);
	}

	// methods
	public void bet() {
		this.numBets ++;
		Random rand = new Random();
		if( rand.nextInt(2) == 0 ) {
			this.currentMoney ++;
			this.gameProcess += "+";
		} else {
			this.currentMoney --;
			this.gameProcess += "-";
		}
	}
	public String play() {
		String process = "";
		while( this.currentMoney > 0 ) {
			this.bet();
		}
		return this.gameProcess;
	}
}
