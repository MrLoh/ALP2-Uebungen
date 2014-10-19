import java.util.*;
import java.lang.*;

public class BinLinkedTree<T extends Comparable<T>,D>
implements Iterable<T>
{
	// ATTRIBUTES
	private TreeNode root = null;
	private int size = 0;

	class TreeNode {
		// ATTRIBUTES
		D data;
		T key;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		// CONSTRUCTOR
		TreeNode(T key, D data, TreeNode left, TreeNode right, TreeNode parent) {
			this.data = data;
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		TreeNode(T key, D data, TreeNode parent) {
			this(key, data, null, null, parent);
		}

		// METHODS
		public String toString(){
			return "" + this.key;
		}
	}

	// INSERT, DELTE METHODS
	public boolean empty() {
	/* Return true if tree is empty. */
	// O{1}
		return this.size == 0;
	}
	public void insert(T key, D data) {
	/* Insert new node with given key and data. */
	// O{log(n)}
		TreeNode node = this.root;
		if( this.empty() ){
			this.root = new TreeNode(key, data, null);
		} else {
			while( true ){
				if( key.compareTo(node.key) > 0 ){
					if( node.right != null ){
						node = node.right;
					} else {
						node.right = new TreeNode(key, data, node);
						break;
					}
				} else if( key.compareTo(node.key) < 0 ) {
					if( node.left != null ){
						node = node.left;
					} else {
						node.left = new TreeNode(key, data, node);
						break;
					}
				} else {
					throw new DuplicateKeyException();
				}
			}
		}
		size++;
	}
	public static class DuplicateKeyException extends RuntimeException {
		public DuplicateKeyException() { super(); }
	}
	public boolean delete(T key) {
	/* Delete the node with the given key and return true, if it does not exists, return false. */
	// O{(log(n))^2}
		try {
			TreeNode node = this.getNode(key);
			boolean isroot = node.key.equals(this.root.key);
			boolean rightchild = !isroot && node.key.compareTo(node.parent.key) > 0;
			if( node.right == null && node.left == null ){
				if( isroot ){
					this.root = null;
				} else if( rightchild ){
					node.parent.right = null;
				} else {
					node.parent.left = null;
				}
			} else if( node.right != null && node.left == null ){
				if( isroot ){
					this.root = node.right;
				} else if( rightchild ){
					node.parent.right = node.right;
				} else {
					node.parent.left = node.right;
				}
			} else if( node.left != null && node.right == null ){
				if( isroot ){
					this.root = node.left;
				} else if( rightchild ){
					node.parent.right = node.left;
				} else {
					node.parent.left = node.left;
				}
			} else {
				TreeNode successor = this.succ(node);
				this.delete(successor.key);
				this.size++;
				successor.left = node.left;
				successor.right = node.right;
				if( isroot ){
					this.root = successor;
				} else if( rightchild ){
					node.parent.right = successor;
				} else {
					node.parent.left = successor;
				}
			}
			this.size--;
			return true;
		} catch( NoSuchElementException e ){
			return false;
		}
	}

	// GET, MIN, MAX, SUCC, PRED METHODS
	public TreeNode getNode(T key) {
	/* Return the node with the given key */
	// O{log(n)}
		TreeNode node = this.root;
		while( node != null ){
			if( key.compareTo(node.key) > 0 ){
				node = node.right;
			} else if( key.compareTo(node.key) < 0 ) {
				node = node.left;
			} else {
				return node;
			}
		}
		throw new NoSuchElementException();
	}
	public D getData(T key){
	/* Return the data with the given key */
	// O{log(n)}
		return this.getNode(key).data;
	}
	public TreeNode minNode(TreeNode node) {
	/* Return the node with the smallest key in the subtree of the given node. */
	// O{log(n)}
		while( node.left != null ){
			node = node.left;
		}
		return node;
	}
	public TreeNode minNode() {
	/* Return the node with the smallest key. */
	// O{log(n)}
		return this.minNode(this.root);
	}
	public TreeNode maxNode(TreeNode node) {
	/* Return the node with the largest key in the subtree of the given node. */
	// O{log(n)}
		while( node.right != null ){
			node = node.right;
		}
		return node;
	}
	public TreeNode maxNode() {
	/* Return the node with the largest key. */
	// O{log(n)}
		return this.maxNode(this.root);
	}
	public TreeNode pred(TreeNode node) {
	/* Return the node with the next smaller key of the given node. */
	// O{log(n)}
		if( node.left != null ){
			return maxNode(node.left);
		} else {
			TreeNode elder = node.parent;
			while( elder != null && node.key.compareTo(elder.key) < 0 ){
				elder = elder.parent;
			}
			return elder;
		}
	}
	public TreeNode succ(TreeNode node) {
	/* Return the node with the next bigger key of the given node. */
	// O{log(n)}
		if( node.right != null ){
			return minNode(node.right);
		} else {
			TreeNode elder = node.parent;
			while( elder != null && node.key.compareTo(elder.key) > 0 ){
				elder = elder.parent;
			}
			return elder;
		}
	}

	// DEPTH METHOD
	public int deep() {
	/* Return depth of tree. */
	// O{n*log(n)}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(this.root);
		int max = 0;
		while( !stack.isEmpty() ){
			TreeNode node = stack.pop();
			if( node.left != null ) {
				stack.push(node.left);
				max = StrictMath.max(max, depth(node.left.key));
			}
			if( node.right != null ){
				stack.push(node.right);
				max = StrictMath.max(max, depth(node.right.key));
			}
		}
		return max;
	}
	public int depth(T key){
	/* Return depth of tree from given node to the root. */
	// O{log(n)}
		int depth = 0;
		TreeNode node = this.getNode(key);
		while( node.parent != null ){
			node = node.parent;
			depth++;
		}
		return depth;
	}

	// BALANCED METHOD
	public boolean perfectBalanced(TreeNode node) {
	/* Return true, if subtree of given node is perfectly balanced. */
	// O{log(n)}
		int leftSize = getSize(node.left.key);
		int rightSize = getSize(node.right.key);
		if( leftSize > rightSize ){
			return leftSize == rightSize+1;
		} else if( leftSize < rightSize ){
			return leftSize+1 == rightSize;
		} else {
			return true;
		}
	}
	public boolean perfectBalanced(T key) {
		TreeNode node = this.getNode(key);
		return perfectBalanced(node);
	}
	public boolean perfectBalanced() {
		return perfectBalanced(this.root);
	}
	public int getSize(T key) {
	/* Return number of nodes in subtree of given node */
	// O{log(n)}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(this.getNode(key));
		int size = 0;
		while( !stack.isEmpty() ){
			TreeNode node = stack.pop();
			size++;
			if( node.left != null ){
				stack.push(node.left);
			}
			if( node.right != null ){
				stack.push(node.right);
			}
		}
		return size;
	}
	public int getSize() {
		return this.size;
	}

	// STRING, ARRAY METHODS
	// public D[] toArray() {
	// better explicitly return, what will be returned.
	public Object[] toArray() {
	/* Return array with the data from all elements of the tree, sorted by the keys. */
	// O{n*log(n)}
		D[] array = (D[]) new Object[this.size];
		int i = 0;
		for( T key : this ){
			array[i] = this.getNode(key).data;
			i++;
		}
		return array;
	}
	public String toStringOrdered() {
	// O{n*log(n)}
		String out = "";
		for( T key : this ){
			out += key + "  ";
		}
		return out;
	}
	public String toString() {
	// O{n*log(n)}
		String out = "";
		int depth = this.deep();
		for( int row=0; row<=depth; row++ ){
			String space = getSpaces( 2 * ((int)Math.pow(2,depth-row)-1) );
			out += space;
			for( int i=(int)Math.pow(2,row); i<(int)Math.pow(2,row+1); i++ ){
				try {
					out += this.getNode(i).key + space + space + "  ";
				} catch( NoSuchElementException e ){
					out += ".." + space + space + "  ";
				}
			}
			out += "\n";
		}
		return out;
	}
	public static String getSpaces(int n){
		String out = "";
		for( int i=0; i<n; i++ ){
			out += " ";
		}
		return out;
	}
	public static char[] getNodePath(int n) {
		String binString = Integer.toBinaryString(n);
		char[] binChars = binString.substring(1, binString.length()).toCharArray();
		return binChars;
	}
	public TreeNode getNode(int n) {
	/** Returns node at given position. */
	// O{log(n)}
		TreeNode node = this.root;
		if( n == 1 ){
			return root;
		}
		for( char c : getNodePath(n) ){
			if( c == '0' && node.left != null ){
				node = node.left;
			} else if( c == '1' && node.right != null ){
				node = node.right;
			} else {
				throw new NoSuchElementException();
			}
		}
		return node;
	}

	// ITERATOR METHOD
	public Iterator<T> iterator() {
		return new LevelOrderIterator();
	}

	private class LevelOrderIterator implements Iterator<T> {
		// ATTRIBUTES
		private int position = 0;
		private int count = 0;

		// METHODS
		public boolean hasNext() {
			return this.count < size;
		}
		public T next() {
			if( !hasNext() ){
				throw new NoSuchElementException();
			}
			this.count++;
			while( true ){
				try{
					this.position++;
					return getNode(this.position).key;
				} catch( NoSuchElementException e ){
					this.position++;
				}
			}


		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// IN ORDER ITERABLE METHODS
	public Iterator<T> iteratorInOrder() {
		return new InOrderIterator();
	}
	private class InOrderIterator implements Iterator<T> {
		// ATTRIBUTES
		private Stack<TreeNode> stack = new Stack<TreeNode>();

		// CONSTRUCTOR
		InOrderIterator() {
			// pushLeftTree(root);
			this.fillStack(root);
		}

		// METHODS
		public boolean hasNext() {
		// O{1}
			return !stack.isEmpty();
		}
		// public T next() {
		// // O{log(n)}
		// 	if( !hasNext() ){
		// 		throw new NoSuchElementException();
		// 	}
		// 	TreeNode node = stack.pop();
		// 	pushLeftTree(node.right);
		// 	return node.key;
		// }
		public T next() {
			if( !hasNext() ){
				throw new NoSuchElementException();
			}
			return this.stack.pop().key;
		}
		// private void pushLeftTree(TreeNode node) {
		// // O{log(n)}
		// 	while (node != null) {
		// 		stack.push(node);
		// 		node = node.left;
		// 	}
		// }
		public void remove() {
			throw new UnsupportedOperationException();
		}
		private void fillStack(TreeNode node) {
			if (node != null) {
				fillStack(node.right);
				this.stack.push(node);
				fillStack(node.left);
			}
		}
	}

	// POST ORDER ITERABLE METHODS
	public Iterator<T> iteratorPostOrder() {
		return new PostOrderIterator();
	}
	private class PostOrderIterator implements Iterator<T> {
		// ATTRIBUTES
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> rightChild = new Stack<Boolean>();

		// CONSTRUCTOR
		PostOrderIterator() {
			// this.pushLeftTree(root);
			this.fillStack(root);
		}

		// METHODS
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		// public T next() {
		// 	if( stack.peek().right == null || rightChild.peek() ){
		// 		rightChild.pop();
		// 		return stack.pop().key;
		// 	} else {
		// 		rightChild.pop();
		// 		rightChild.push(true);
		// 		pushLeftTree(stack.peek().right);
		// 		return next();
		// 	}
		// }
		public T next() {
			if( !hasNext() ){
				throw new NoSuchElementException();
			}
			return this.stack.pop().key;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		// private void pushLeftTree(TreeNode node) {
		// 	if (node != null) {
		// 		stack.push(node);
		// 		rightChild.push(false);
		// 		pushLeftTree(node.left);
		// 	}
		// }
		private void fillStack(TreeNode node) {
			if (node != null) {
				this.stack.push(node);
				fillStack(node.right);
				fillStack(node.left);
			}
		}
	}

	// PRE ORDER ITERABLE METHODS
	public Iterator<T> iteratorPreOrder() {
		return new PreOrderIterator();
	}
	private class PreOrderIterator implements Iterator<T> {
		// ATTRIBUTES
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// CONSTRUCTOR
		PreOrderIterator() {
			this.fillStack(root);
		}

		// METHODS
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		public T next() {
			if( !hasNext() ){
				throw new NoSuchElementException();
			}
			return this.stack.pop().key;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		private void fillStack(TreeNode node) {
			if (node != null) {
				fillStack(node.right);
				fillStack(node.left);
				this.stack.push(node);
			}
		}
	}


}
