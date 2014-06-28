public interface Queue<E> {
	public void enqueue( E element );
	public E dequeue() throws EmptyQueueException;
	public E head() throws EmptyQueueException;
	public boolean empty();
	public String toString();
}
