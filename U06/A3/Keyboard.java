import java.io.BufferedInputStream;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * This is a very simple class which provide methods for reading data from the Keyborad.
 * following types of data can be read.
 * byte, short, int, long, boolean, double, float, String and BigInteger
 */

public class Keyboard{

	private static Scanner scanner = new Scanner(new BufferedInputStream(System.in));

	public static int readInt(){
		return scanner.nextInt();
	}

	public static double readDouble(){
		return scanner.nextDouble();
	}

	public static boolean readBool(){
		return scanner.nextBoolean();
	}

    public static float readFloat() {
        return scanner.nextFloat();
   }

   public static short readShort() {
        return scanner.nextShort();
   }

   public static long readLong() {
       return scanner.nextLong();
   }

   public static byte readByte() {
       return scanner.nextByte();
   }

   public static String readText(){
	   return scanner.nextLine();
   }

   public static BigInteger readBigInteger(){
	   return scanner.nextBigInteger();
   }

   public static void main(String[] args){
		System.out.print("int a = ");
		int a = Keyboard.readInt();

		System.out.print("boolean b = ");
		boolean b = Keyboard.readBool();

		System.out.print("d = ");
		double d = Keyboard.readDouble();

		System.out.print("BigInteger big = ");
		BigInteger big = Keyboard.readBigInteger();

		BigInteger bigger = big.pow(3);

		System.out.println("big = " + big);
		System.out.println("bigger = " + bigger);
		System.out.println(bigger);

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("d = " + d);
	}
}// end of class Keyboard
