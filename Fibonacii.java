package classwork;
import java.util.*;

/*Program to find any desired number in the Fibonacii sequence,
 * uses 0-based indexing for simplicity (i.e. 0->1, 1->1, 2->2, etc).
 * Uses a loop based approach rather than the recursive approach in 
 * order to save resources and for faster computation on larger numbers
 * in the sequence
 */
public class Fibonacii {
	
	//Main tester mathod
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the desired Fibonacii number (0-based index): ");
			int goal = c.nextInt();
			System.out.println(calcFin(goal));
		}
	}
	
	//Calculation method
	public static int calcFin(int goal) {
		
		//Generic case for first 2 terms
		if(goal==0 || goal==1) {return 1;} 
		
		//Using a loop and 3 variables to add up to the desired number
		int prev = 1;
		int temp = 1;
		int fin = 1;
		for(int i = 2; i<=goal; i++) {
			temp = fin;
			fin = fin+prev;
			prev = temp;
		}
		
		//Return the result
		return fin;
	}
}
