package Chatbot;
import java.util.*;

//Main class/runner for the chatbot
public class ChatMain {
	
	//Main method
	public static void main(String[] args) {
		
		//Constructing the bot and a scanner for input
		ChatBot bot = new ChatBot();
		Scanner in = new Scanner(System.in);
		
		//Prints a simple introduction
		System.out.println("Hello, I'm "+bot.getName()+", let's chat\n");
		
		//Main loop, takes the user's input and returns an appropriate response
		while(true) {
			System.out.println(bot.getResponse(in.nextLine()));
		}
	}
}
