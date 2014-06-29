public interface Queue<E, P> {
	public void enqueue(P priority, E data);
	public E dequeue() throws EmptyQueueException;
	public E highest() throws EmptyQueueException;
	public boolean empty();
}
