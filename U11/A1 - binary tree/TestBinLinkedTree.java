import java.util.*;
import java.lang.*;

public class TestBinLinkedTree {
	public static void print(Object o) {
		System.out.println(o);
	}
	public static BinLinkedTree<Num,String> newTree(int[] ints) {
		BinLinkedTree<Num,String> tree = new BinLinkedTree<Num,String>();
		for( int i : ints ) {
			tree.insert(new Num(i), "a");
		}
		return tree;
	}

	public static void main(String[] args) {

		// GET, MIN, MAX, SUCC, PRED
		int[] ints1 = {6,4,10,2,5,8,9,7,1,3,12,11};
		BinLinkedTree<Num,String> tree1 = newTree(ints1);
		print(tree1);
		print("depth: " + tree1.deep());
		print("node 06: " + tree1.getNode(new Num(6)));
		print("node 10: " + tree1.getNode(new Num(10)));
		print("");
		print("min: " + tree1.minNode());
		print("min 10: " + tree1.minNode(tree1.getNode(new Num(10))));
		print("max: " + tree1.maxNode());
		print("max 04: " + tree1.maxNode(tree1.getNode(new Num(4))));
		print("");
		print("pred 06: " + tree1.pred(tree1.getNode(new Num(6))));
		print("succ 06: " + tree1.succ(tree1.getNode(new Num(6))));
		print("pred 08: " + tree1.pred(tree1.getNode(new Num(8))));
		print("succ 09: " + tree1.succ(tree1.getNode(new Num(9))));
		print("pred 07: " + tree1.pred(tree1.getNode(new Num(7))));
		print("succ 05: " + tree1.succ(tree1.getNode(new Num(5))));
		print("pred 01: " + tree1.pred (tree1.getNode(new Num(01))));
		print("succ 12: " + tree1.succ(tree1.getNode(new Num(12))));

		// DELETING
		int[] ints2 = {53,27,69,13,34,63,95,8,17,30,46,66,5,9,15,18,32,50,29,68,71,64,98,99,97};
		BinLinkedTree<Num,String> tree2 = newTree(ints2);
		print(tree2);
		print("delete 15 =>");
		tree2.delete(new Num(15));
		print(tree2);
		print("delete 46 =>");
		tree2.delete(new Num(46));
		print(tree2);
		print("delete 27 =>");
		tree2.delete(new Num(27));
		print(tree2);
		print("delete 53 =>");
		tree2.delete(new Num(53));
		print(tree2);
		print("");

		// KOMMUTATIVE DELETING
		print("Ist komutativ, da der Knoten durch seinen Nachfolger \nersetzt wird und die Suche nach Nachfolgern Kommutativ \nist.\n");
		BinLinkedTree<Num,String> tree2a = newTree(ints2);
		BinLinkedTree<Num,String> tree2b = newTree(ints2);
		print(tree2a);
		print("delete 53 & 63 =>");
		tree2a.delete(new Num(53));
		tree2a.delete(new Num(63));
		print(tree2a);
		print("delete 63 & 53 =>");
		tree2b.delete(new Num(63));
		tree2b.delete(new Num(53));
		print(tree2b);

	}
}
