public class Test {
	public static void main(String[] args) {
		// Gambler Tests
		Gambler g1 = new Gambler("Tobias", 10);
		System.out.println(g1);
		System.out.println(g1.play());
		System.out.println(g1);
		System.out.println();
		Gambler g2 = new Gambler();
		System.out.println(g2);
		System.out.println(g2.play());
		System.out.println(g2);
		System.out.println();

		// Casino Tests
		Casino casino = new Casino();
		System.out.println(casino);
		System.out.println(casino.getMoney());
		System.out.println(casino);
	}
}
