public class Casino {
	// attributes
	private int size;
	private String name;
	Gambler[] gamblers;
	String gameProcesses;

	// constructor
	public Casino(int n, String name, int startMoney) {
		this.size = n;
		this.name = name;
		this.gamblers = new Gambler[n];
		for( int i=0 ; i<n; i++ ) {
			this.gamblers[i] = new Gambler(startMoney);
		}
		gameProcesses = "";
	}
	public Casino() {
		this(10, "Grand Royale Casino", 10);
	}

	// defaults
	public String toString() {
		String out = "<Casino>: " + this.name + "\n";
		for( int i=0 ; i<this.size ; i++ ) {
			out = out + this.gamblers[i] + "\n";
		}
		return out;
	}

	// methods
	public String getMoney() {
		for( int i=0 ; i<this.size ; i++ ) {
			String process = this.gamblers[i].play();
			this.gameProcesses += String.format("%s\n%s\nLost all his money\n\n", this.gamblers[i], process);
		}
		return this.gameProcesses;
	}
}
