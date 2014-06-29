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
		this.queue.enqueue(this.randomPriority(), this.nextMessage());
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
		int iterations = 100;
		Random rand = new Random();
		for( int i=0; i<iterations; i++ ){
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
