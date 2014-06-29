public class TestListQueue {
	public static void main(String[] args) {
		// TESTS
		ListQueue<String> strings = new ListQueue<String>();
		System.out.println("empty? " + strings.empty());
		System.out.println(strings);
		strings.enqueue("Iterators");
		strings.enqueue("are");
		strings.enqueue("useful");
		System.out.println("empty? " + strings.empty());
		System.out.println(strings);

		String sentence = "";
		for( String element : strings ){
			sentence += " " + element ;
		}
		System.out.println(sentence + ".");

		try {
			System.out.println("removed: " + strings.dequeue());
			System.out.println("removed: " + strings.dequeue());
			System.out.println("next: " + strings.head());
		} catch(Exception e) {
			System.out.println("Empty Queue!");
		}
		System.out.println(strings);
	}
}
