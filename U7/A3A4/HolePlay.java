public class HolePlay {
	// attributes
	Player player = new Player();

	// methods
	public void play() {
		while( player.playing ) {
			String pick = player.randomPick();
			System.out.println(pick + player);
		}
		String out = player.won? "\n  WON" : "\n  LOST";
		System.out.println(out);
	}

	// main
	public static void main(String[] args) {
		HolePlay thisPlay = new HolePlay();
		System.out.println(thisPlay.player);
		thisPlay.play();
	}
}
