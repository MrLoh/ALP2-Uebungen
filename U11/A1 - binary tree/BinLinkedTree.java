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

	// METHODS
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
	public boolean empty() {
	/* Return true if tree is empty. */
	// O{1}
		return this.size == 0;
	}
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
				max = StrictMath.max(max, depth(node.left));
			}
			if( node.right != null ){
				stack.push(node.right);
				max = StrictMath.max(max, depth(node.right));
			}
		}
		return max;
	}
	public int depth(TreeNode node){
	// O{log(n)}
		int depth = 0;
		while( node.parent != null ){
			node = node.parent;
			depth++;
		}
		return depth;
	}

	public D[] toArray() {
	/* Return array with the data from all elements of the tree, sorted by the keys. */
	// O{n*log(n)}
		D[] array = (D[]) new Object[size];
		int i = 0;
		for( T key : this ){
			array[i] = this.getNode(key).data;
			i++;
		}
		return array;
	}

	public String toStringOrdered() {
	// O{n*log(n)}
		String out = "|";
		for( T key : this ){
			out += String.format(" %s |", key);
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
					out += " ." + space + space + "  ";
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


	// ITERABLE METHODS
	public Iterator<T> iterator() {
		return new InorderIterator();
	}
	private class InorderIterator implements Iterator<T> {
		// ATTRIBUTES
		private Stack<TreeNode> stack = new Stack<TreeNode>();

		// CONSTRUCTOR
		InorderIterator() {
			pushLeftTree(root);
		}

		// METHODS
		public boolean hasNext() {
		// O{1}
			return !stack.isEmpty();
		}
		public T next() {
		// O{log(n)}
			if( !hasNext() ){
				throw new NoSuchElementException();
			}
			TreeNode node = stack.pop();
			pushLeftTree(node.right);
			return node.key;
		}
		private void pushLeftTree(TreeNode node) {
		// O{log(n)}
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


}
