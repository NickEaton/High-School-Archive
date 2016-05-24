package classwork;
import java.util.*;

/*Reverses any inputed string, and prints it
 * back out to the user
 */
public class FullReverse {
	
	//Main loop
	public static void main(String[] args) {
		
		//Create the Scanner object
		Scanner c = new Scanner(System.in);
		
		//Loop until user exits
		while(true) {
			System.out.print("Enter something to be reversed: ");
			String in = c.nextLine();
			System.out.println(reverse(in));
		}
	}
	
	//Method to revers
	public static String reverse(String in) {
		
		//Clean up the string, cut off whitespace & remove caps
		in = in.trim().toLowerCase();
		int words = 0;
		
		//Create an array & reverse the String
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		for(int i=0; i<in.length(); i++) {
			list.set(words, list.get(words)+in.charAt(i));
			if(in.charAt(i) ==' '){
				list.add("");
				words++;
			}
		}
		String finalVal = "";
		int finSize = 0;
		for(int i=0; i<list.size(); i++) {
			finSize+=list.get(i).length();
		}
		for(int i=0; i<list.size(); i++) {
			finalVal+=swap(list.get(i));
		}
		
		//return the resultant String
		return finalVal;
	}
	
	//private method to conveniently swap characters
	public static String swap(String in) {
		in = in.trim();
		String nString ="";
		for(int i=in.length()-1; i>=0; i--) {
			nString+=in.charAt(i);
		}
		return nString+" ";
	}
}

