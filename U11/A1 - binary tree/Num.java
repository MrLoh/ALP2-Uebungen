import java.lang.*;
import java.util.*;

public class Num implements Comparable<Num> {
	int num;
	public Num(int num) {
		if( num < 100 ){
			this.num = num;
		} else {
			throw new RuntimeException("Num just excepts Elements < 100");
		}
	}
	public int compareTo(Num other) {
		if( this.num < other.num ){
			return -1;
		} else if( this.num > other.num ){
			return 1;
		} else {
			return 0;
		}
	}
	public String toString() {
		if( this.num < 10 ){
			return "0" + this.num;
		} else {
			return "" + this.num;
		}
	}
}
