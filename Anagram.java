package classwork;
import java.util.*;

/*Filters a user-input list of Strings to remove all	
 * values which are not anagrams of the target
 * String
 */
public class Anagram {
	public static void main(String[] args) {
		
		//Scanner for basic input
		Scanner c = new Scanner(System.in);
		
		//Intro and user input to get the target
		System.out.println("This program inputs a target and an array of Strings\n"
				+ "And prints the array while removing all anagrams of the target\n"
				+ "from the array.");
		System.out.print("\nEnter the target: ");
		String tar = c.nextLine();
		
		//Initialize the list
		ArrayList<String> list = new ArrayList<String>();
		
		//Fencepost loop to input the list from the user with the enter key set as the sentinel
		System.out.print("Enter the first value of the array <ENTER to quit>: ");
		list.add(c.nextLine());
		String in = "<Sample>";
		while(!in.equals("")) {
			System.out.print("Enter the next item in the array <ENTER to quit>: ");
			in =c.nextLine();
			if(in=="") {break;}
			list.add(in);
		} 
		
		//Removing all items which are not anagrams of the target
		for(int i=0; i<list.size(); i++) {
			if(!compAnagram(tar, list.get(i))) {list.remove(i); i--;}
		}
		
		//Print the resultant list
		System.out.println(list.toString());
	}
	
	//Logic for checking for an anagram
	public static boolean compAnagram(String target, String test) {
		if(target.length()!=test.length()) {return false;}
		char[] tar = new char[target.length()];
		char[] tes = new char[target.length()];
		for(int i=0; i<target.length(); i++) {
			tar[i] = target.charAt(i);
			tes[i] = test.charAt(i);
		}
		Arrays.sort(tar);
		Arrays.sort(tes);
		for(int i=0; i<tar.length; i++) {
			if(tar[i]!=tes[i]) {return false;}
		}
		return true;
	}
}
