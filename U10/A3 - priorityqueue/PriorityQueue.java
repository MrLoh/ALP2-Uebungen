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
		TreeNode<P,D> parent;

		// CONSTRUCTOR
		TreeNode(P priority, D data, TreeNode<P,D> left, TreeNode<P,D> right, TreeNode<P,D> parent) {
			this.priority = priority;
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		TreeNode(P priority, D data, TreeNode<P,D> parent) {
			this(priority, data, null, null, parent);
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
			this.root = new TreeNode<P,D>(priority, data, null);
		} else {
			this.size++;
			TreeNode<P,D> parent = this.getNode((this.size)>>1);
			assert parent != null;
			if( ((this.size)&1) == 0 ){
				parent.left = new TreeNode<P,D>(priority, data, parent);
			} else {
				parent.right = new TreeNode<P,D>(priority, data, parent);
			}
			assert this.getNode(this.size) != null;
			this.heapifyUp(this.getNode(this.size));
		}
	}
	public D dequeue() throws EmptyQueueException{
	/** Removes and returns the element with highest priority and reheapifies. */
		if( this.empty() ){
			throw new EmptyQueueException();
		} else {
			assert this.root != null;
			D data = this.root.data;
			TreeNode<P,D> last = this.getNode(this.size);
			this.swapContent(this.root, last);
			this.heapifyDown(this.root);
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
			assert this.root != null;
			return this.root.data;
		}
	}
	public void clear() {
	/** Clears cue. */
		for( int i=size; i>=1; i-- ){
			TreeNode<P,D> last = this.getNode(i);
			last = null;
			this.size--;
		}
		assert this.empty() && this.root == null && this.root.left == null;
	}
	public boolean empty() {
	/** checks wether the queue is empty. */
		return (this.size == 0);
	}

	// HEAP METHODS
	private void heapifyDown(TreeNode<P,D> node) {
	/** Ensures the heap condition from a given node on down. */
	TreeNode<P,D> biggest;
		if( node.left != null && node.priority.compareTo(node.left.priority) < 0 ) {
			biggest = node.left;
		} else {
			biggest = node;
		}
		if( node.right != null && biggest.priority.compareTo(node.right.priority) < 0 ) {
			biggest = node.right;
		}
		if( biggest.priority != node.priority ){
			this.swapContent(node, biggest);
			assert node.priority.compareTo(biggest.priority) < 0;
			this.heapifyDown(biggest);
		}
	}
	private void heapifyUp(TreeNode<P,D> node) {
	/** Ensures the heap condition from a given node on up. */
		if( node.parent != null && node.priority.compareTo(node.parent.priority) > 0 ) {
			this.swapContent(node, node.parent);
			assert node.priority.compareTo(node.parent.priority) < 0;
			this.heapifyUp(node.parent);
		}
	}
	public boolean testHeap() {
		boolean test = true;
		for( int i=1; i<=this.size; i++ ){
			test = test && ( this.getNode(i).left == null || this.getNode(i).priority.compareTo(this.getNode(i).left.priority) >= 0 );
			test = test && ( this.getNode(i).right == null || this.getNode(i).priority.compareTo(this.getNode(i).right.priority) >= 0 );
		}
		return test;
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
