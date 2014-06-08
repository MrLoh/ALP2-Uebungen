public class ArrayTests {
	public static void main(String[] args) {
		int[] zahlen = new int[12];
		int[] primes = { 2, 3, 5, 7, 11, 13, 17 };
		double[][] matrix = new double[3][3];
		System.out.println(zahlen.length);
		System.out.println();
		for( int i=0 ; i<zahlen.length ; i++ ) {
			System.out.println(zahlen[i]);
		}
		System.out.println();
		System.out.println(primes.length);
		System.out.println();
		for( int i=0 ; i<primes.length ; i++ ) {
			System.out.println(primes[i]);
		}
		System.out.println();
		System.out.println(matrix[2][2]);
	}
}
