import java.util.*;
import java.lang.*;

public class TestChars {
	public static char[] getElement(int n) {
		String binString = Integer.toBinaryString(n);
		char[] binChars = binString.substring(1, binString.length()).toCharArray();
		for( char c : binChars ){
			if( c == '0' ){
				System.out.println("null");
			} else if( c == '1' ){
				System.out.println("one");
			}
		}
		return binChars;
	}
	public static void main(String[] args) {
		System.out.println(getElement(5));
	}
}
