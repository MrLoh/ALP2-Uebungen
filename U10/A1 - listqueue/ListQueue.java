import java.util.*;

public class ListQueue<E> implements Queue<E>, Iterable<E> {
	// ATTRIBUTES
	private ListNode<E> head;
	private ListNode<E> tail;

	// CONSTRUCTORS
	public ListQueue() {
		this.head = null;
		this.tail = null;
	}

	// LISTNODE CLASS
	class ListNode<E> {
		// ATTRIBUTES
		E element;
		ListNode<E> next;

		// CONSTRUCTORS
		ListNode(E element, ListNode<E> next) {
			this.element = element;
			this.next = next;
		}
		ListNode(E element) {
			this(element, null);
		}
		ListNode() {
			this(null, null);
		}
	}

	// QUEUE METHODS
	public void enqueue( E element ) {
	/** Adds an element at the end of the list. */
		if( this.empty() ){
			this.tail = this.head = new ListNode<E>(element);
		} else {
			this.tail = this.tail.next = new ListNode<E>(element);
		}
	}
	public E dequeue() throws EmptyQueueException {
	/** Removes and returns the first element of the queue. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			E element = this.head.element;
			this.head = this.head.next;
			return element;
		}
	}
	public E head() throws EmptyQueueException {
	/** returns the first element of the queue. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			return this.head.element;
		}
	}
	public boolean empty() {
	/** checks wether the queue is empty. */
		return (this.head == null);
	}
	public String toString(){
		String out = "LISTQUEUE = | ";
		for( E element : this ){
			out += element + " | ";
		}
		return out;
	}

	// ITERABLE METHODS
	public Iterator<E> iterator(){
		return new QueueIterator<E>(head);
	}

	class QueueIterator<E> implements Iterator<E> {
		// ATTRIBUTES
		ListNode<E> current;

		// CONSTRUCTORS
		QueueIterator(ListNode<E> head) {
			this.current = head;
		}

		// METHODS
		public boolean hasNext() {
			return (current != null);
		}
		public E next() {
			if( !this.hasNext() ){
				throw new NoMoreElementsException();
			} else {
				E element = this.current.element;
				this.current = this.current.next;
				return element;
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
