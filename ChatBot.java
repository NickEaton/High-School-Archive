package Chatbot;
import java.util.*;

/*Simple chat AI to simulate a very simple human
 * conversation
 */
public class ChatBot {
	
	//Name field and a list of all possible names
	private String name;
	private String[] nameList = {"Red", "Ethan", "Brendan", "Lucas", "Nate", "Calem", "May", "Dawn", "Rosa", "Serena"};
	
	//Constructor which simply selects a random name
	public ChatBot() {
		name = nameList[new Random().nextInt(10)];
	}
	
	/*Main method which calculates a response based on
	 * the input from the user. Attempts to respond 
	 * intuitively using ques from the String the user
	 * input
	 */
	public String getResponse(String in) {
		in = in.toLowerCase();
		if(in.contains("hi") || in.contains("hello") || in.contains("hia")
				||in.contains("sup")) {
			return "Hello, I'm "+name+", nice to meet you";
		}
		if(in.contains("how") || in.contains("whats up") || in.contains("hows")
				||in.contains("how's") || in.contains("what's up")) {
			return "I'm fine, thank you. How are you?";
		}
		if(in.contains("Dog") || in.contains("Cat")) {
			return "Wow, I love pets too! Tell me more about your pets";
		}
		else if(in.contains("mom") || in.contains("dad") || in.contains("brother")
				||in.contains("sister") || in.contains("mother") || in.contains("father")
				||in.contains("aunt") || in.contains("uncle") || in.contains("niece") 
				||in.contains("nephew")) {
			return "Family is a great part of life! Tell me more about your family";
		}
		else if(in.contains("movie") || in.contains("film") || in.contains("theatre") 
				||in.contains("cinema")) {
			return "I love movies! What's your favorite movie?";
		}
		else if(in.contains("food") || in.contains("restaraunt") || in.contains("pepsi")
				||in.contains("coke")) {
			return "What's your favorite kind of food?";
		}
		else if(in.contains("sunny") || in.contains("cloudy") || in.contains("rainy")) {
			return "I'm happy no matter the weather!";
		}
		else if(in.contains("game") || in.contains("pokemon") || in.contains("video")) {
			return "I love games, pokemon is my favorite!";
		}
		if(new Random().nextInt(3)==0) {return "Nice weather we're having, do you prefer it to be sunny or chilly?";}
		if(new Random().nextInt(3)==0) {return "Hmm interesting. Tell me more please";}
		if(new Random().nextInt(3)==0) {return "Oh really? Hey, what's your favorite book?";}
		return "That's pretty cool! Quick, Pepsi or Coke?";
	}

	//Simple accessor method for the name field
	public String getName() {
		return this.name;
	}
}
