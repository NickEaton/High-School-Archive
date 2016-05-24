package classwork;
import java.util.*;

/*Program to find the n'th prime number, using an 
 * array of prime numbers to calculate the next one.
 * Efficient runtime up to 10000 primes
 */
public class FindPrime {
	
	//Main method to continually find the desired prime
	public static void main(String[] args) {
		
		//Create the scanner
		Scanner c = new Scanner(System.in);
		
		//Loop until user quites the program
		while(true) {
			System.out.print("Enter the desired prime #: ");
			int prime = c.nextInt();
			System.out.println("The prime at this index is: "+primeAtIndex(prime));
		}
	}
	
	//Finds the prime at the given index
	public static int primeAtIndex(int index) {
		int[] primes = new int[index+3];
		int nPrime = index+3;
		int fCount = 0;
		int count = 0;
		
		if(index==0) {return 2;}
		if(index==1) {return 3;}
		
		index+=3;
		
		while(nPrime>0) {
			
			if(isPrime(fCount)) {
				primes[count]=fCount;
				nPrime--;
				count++;
			}
			fCount++;
		}
		
		return primes[index-1];
	}
	
	//Quick test if a value is prime or not
	public static boolean isPrime(int test) {
		for(int i=2; i<test; i++) {
			if(test%i==0) {return false;}
		}
		
		return true;
	}
}
