import java.lang.*;
import java.util.*;

public class SimulateMessageTraffic {
	// ATTRIBUTES
	public PriorityQueue<Integer, String> queue = new PriorityQueue<Integer, String>();
	public Random rand = new Random();
	private int messageNumber = 0;

	// METHODS
	public String nextMessage() {
		this.messageNumber++;
		return "message #" + messageNumber;
	}
	public int randomPriority() {
		return rand.nextInt(9);
	}
	public void addMessage() {
		int priority = this.randomPriority();
		String data = this.nextMessage() + " P:"+priority;
		// String data = this.nextMessage();
		this.queue.enqueue(priority, data);
	}
	public String removeMessage() {
		try {
			return this.queue.dequeue();
		} catch( EmptyQueueException e ){
			return "    empty queue";
		}
	}

	public static void main(String[] args) {
		// TESTS
		SimulateMessageTraffic simulator = new SimulateMessageTraffic();
		for( int i=0; i<25; i++ ){
			simulator.addMessage();
		}
		System.out.println(simulator.queue);
		System.out.println(simulator.queue.testHeap());
		System.out.println("\n");

		simulator.queue.clear();
		System.out.println(simulator.queue.empty());
		int iterations = 100;
		Random rand = new Random();
		for( int i=0; i<iterations; i++ ){
			// System.out.println(simulator.queue);
			boolean newmessage = rand.nextBoolean();
			if( newmessage ){
				simulator.addMessage();
				System.out.println("    added message");
			} else {
				System.out.println(simulator.removeMessage());
			}
		}
	}
}
