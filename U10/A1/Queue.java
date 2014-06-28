public interface Queue<E> {
	public void enqueue( E element );
	// fuegt ein Element am Ende der Warteschlange ein

	public E dequeue() throws EmptyQueueException;
	// das erste Element der Warteschlange wird entfernt und als Rueckgabewert der Operation zurueckgegeben

	public E head() throws EmptyQueueException;
	// die Referenz des ersten Elements der Warteschlange wird zurueckgegeben ohne diese zu entfernen

	public boolean empty();
	 // ueberprueft, ob die Warteschlange leer ist

	public String toString();
	// nur die Elemente der Warteschlange werden in die richtige Reihenfolge als Zeichenkette zurueckgegeben
}
