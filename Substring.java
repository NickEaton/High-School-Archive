package classwork;
import java.util.*;

//Rewriting the String method substring without using the initial method
public class Substring {
	
	//Main test method
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the String to scan: ");
			String in = c.nextLine();
			System.out.print("Enter the desired sub-string: ");
			String tar = c.nextLine();
			System.out.println("The index of the substring is: "+substring(in, tar));
		}
	}
	
	/*Takes two strings as paramaters, and returns the index at which
	 * the target string begins in the inputed String. Returns -1 if
	 * the target is not contained in the input String 
	 */
	public static int substring(String in, String target) {
		int startIndex=0;
		for(int i=0; i<in.length()-target.length()+1; i++) {
			startIndex=i;
			for(int j=0; j<target.length(); j++) {
				if(in.charAt(i+j)!=target.charAt(j)) {break;}
				if(j==target.length()-1&&in.charAt(i+j)==target.charAt(j)) {
					return startIndex;
				}
			}
		}
		return -1;
	}
}
