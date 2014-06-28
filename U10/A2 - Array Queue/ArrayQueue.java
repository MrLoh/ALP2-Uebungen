import java.util.*;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {
	// ATTRIBUTES
	private E[] sArray;
	private int head;
	private int tail;
	private int max;

	// CONSTRUCTORS
	public ArrayQueue(){
		// this.sArray = (E[]) new Object[2];
		this.sArray = (E[]) new Object[5];
		this.max = sArray.length-1;
		this.head = 0;
		this.tail = 0;
	}

	// QUEUE METHODS
	public void enqueue( E element ) {
	/** Adds an element at the end of the list. */
		if( this.full() ){
			this.resizeSArray();
		}
		this.sArray[this.tail] = element;
		this.tail = nextPosition(this.tail);
	}
	public E dequeue() throws EmptyQueueException {
	/** Removes and returns the first element of the queue. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			E element = sArray[head];
			this.head = nextPosition(this.head);
			return element;
		}
	}
	public E first() throws EmptyQueueException {
	/** returns the first element of the queue. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			return sArray[head];
		}
	}
	public boolean empty() {
	/** checks wether the queue is empty. */
		return (this.head == this.tail);
	}
	private boolean full() {
	/** checks wether the array is full. */
		return (this.head == 0 && this.tail == this.max) || (this.head == this.tail+1) ;
	}
	private int nextPosition(int position) {
		if( position == this.max ){
			return 0;
		} else {
			return position+1;
		}
	}
	private void resizeSArray() {
		E[] temp = (E[]) new Object[this.sArray.length*2];
		for( int i=0; i<this.max; i++ ){
			if( i+this.head <= this.max ){
				temp[i] = this.sArray[i+this.head];
			} else {
				temp[i] = this.sArray[i+this.head-this.max-1];
			}
		}
		this.sArray = temp;
		this.head = 0;
		this.tail = this.max;
		this.max = (this.max+1)*2-1;
	}
	public String toString(){
		String out = "ARRAYQUEUE = | ";
		// for( E element : this.sArray){
		// 	out+= element + " | ";
		// }
		// out += "\n\t";
		for( E element : this ){
			out += element + " | ";
		}
		return out;
	}

	// ITERABLE METHODS
	public Iterator<E> iterator(){
		return new QueueIterator<E>(head, sArray);
	}

	class QueueIterator<E> implements Iterator<E> {
		// ATTRIBUTES
		int current;
		private E[] sArray;

		// CONSTRUCTORS
		QueueIterator(int head, E[] sArray) {
			this.current = head;
			this.sArray = sArray;
		}

		// METHODS
		public boolean hasNext() {
			return (current != tail);
		}
		public E next() {
			if( !this.hasNext() ){
				throw new NoSuchElementException();
			} else {
				E element = sArray[this.current];
				this.current = nextPosition(this.current);
				return element;
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
