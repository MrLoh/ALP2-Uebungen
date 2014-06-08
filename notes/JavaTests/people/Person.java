public class Person {
	// attributes
	public String name;
	// constructor
	public Person(String name) {
		this.name = name;
	}
	// methods
	public boolean equals(Object o) {
		Person p = (Person) o;
		return this.name.equals(p.name);
	}
}
