import java.util.*;
import java.lang.*;

public class PriorityQueue <P extends Comparable<P>,D> implements Queue<D,P> {
	// ATTRIBUTES
	private TreeNode<P,D> root;
	private TreeNode<P,D> last;
	private int size;

	// CONSTRUCTOR
	PriorityQueue() {
		this.root = null;
		this.last = null;
		this.size = 0;
	}

	class TreeNode<P,D> {
		// ATTRIBUTES
		P priority;
		D data;
		TreeNode<P,D> left;
		TreeNode<P,D> right;

		// CONSTRUCTOR
		TreeNode(P priority, D data, TreeNode<P,D> left, TreeNode<P,D> right) {
			this.priority = priority;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		TreeNode(P priority, D data) {
			this(priority, data, null, null);
		}

		// METHODS
		public String toString() {
			return this.data + " : P" + this.priority;
		}
	}

	// METHODS
	public static char[] getNodePath(int n) {
		String binString = Integer.toBinaryString(n);
		char[] binChars = binString.substring(1, binString.length()).toCharArray();
		return binChars;
	}
	public TreeNode<P,D> getNode(int n) {
	/** Returns node at given position. */
		TreeNode<P,D> node = this.root;
		for( char c : getNodePath(n) ){
			if( c == '0' ){
				node = node.left;
			} else if( c == '1' ){
				node = node.right;
			}
		}
		return node;
	}
	public String toString() {
		String out = "PriorityQueue = | ";
		if( this.empty() ){
			out += "EMPTY";
		}
		for( int i=1; i<=size; i++ ){
			TreeNode<P,D> node = this.getNode(i);
			out += node + " | ";
		}
		return out;
	}

	// QUEUE METHODS
	public void enqueue(P priority, D data) {
	/** Adds a node and reheapifies. */
		if( this.empty() ){
			this.size++;
			this.root = new TreeNode<P,D>(priority, data);
		} else {
			TreeNode<P,D> last = this.getNode(size+1);
			last = new TreeNode<P,D>(priority, data);
			for( int i=size; i>=1; i-- ){
				this.swapContent(this.getNode(i+1), this.getNode(i));
			}
			this.size++;
			this.root.priority = priority;
			this.root.data = data;
			this.heapify(this.root);
		}
	}
	public D dequeue() throws EmptyQueueException{
	/** Removes and returns the element with highest priority and reheapifies. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			D data = this.root.data;
			TreeNode<P,D> last = this.getNode(this.size);
			this.swapContent(this.root, last);
			this.heapify(this.root);
			last = null;
			this.size--;
			return data;
		}
	}
	public D highest() throws EmptyQueueException {
	/** Returns the element with highest priority. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			return this.root.data;
		}
	}
	public boolean empty() {
	/** checks wether the queue is empty. */
		return (this.size == 0);
	}

	// HEAP METHODS
	private void heapify(TreeNode<P,D> node) {
	/** Ensures the heap condition from a given node on down. */
		if( node.left != null && node.priority.compareTo(node.left.priority) < 0 ) {
			this.swapContent(node, node.left);
			this.heapify(node);
		} else if( node.right != null && node.priority.compareTo(node.right.priority) < 0 ) {
			this.swapContent(node, node.right);
			this.heapify(node);
		}
	}
	private void swapContent(TreeNode<P,D> a, TreeNode<P,D> b) {
	/** Swaps two given nodes in the tree. */
		P aPriority = a.priority;
		D aData = a.data;
		P bPriority = b.priority;
		D bData = b.data;
		a.priority = bPriority;
		a.data = bData;
		b.priority = aPriority;
		b.data = aData;
	}
}
