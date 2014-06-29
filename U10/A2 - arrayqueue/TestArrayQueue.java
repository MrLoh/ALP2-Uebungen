public class TestArrayQueue {
	public static void main(String[] args) {
		// TESTS
		ArrayQueue<String> strings = new ArrayQueue<String>();
		System.out.println("empty? " + strings.empty());
		System.out.println(strings);
		strings.enqueue("Iterators");
		strings.enqueue("are");
		strings.enqueue("really");
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
			System.out.println("removed: " + strings.dequeue());
			System.out.println("next: " + strings.first());
		} catch(Exception e) {
			System.out.println("Empty Queue!");
		}
		System.out.println(strings);

		strings.enqueue("iterators");
		// System.out.println(strings);
		strings.enqueue("are");
		strings.enqueue("really");
		// System.out.println(strings);
		strings.enqueue("useful");
		strings.enqueue("are");
		// System.out.println(strings);
		strings.enqueue("they");
		strings.enqueue("not");
		System.out.println(strings);
	}
}
