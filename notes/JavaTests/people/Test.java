public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("Tobias");
		Person p2 = new Person("Tobias");
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.test("test"));

		Student s1 = new Student();
	}
}
