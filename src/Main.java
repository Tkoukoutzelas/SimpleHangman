import java.util.Scanner;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
  
  boolean endgame=false;
  
  int gamespld=0; int gameswon=0; int gameslost=0;
  Dictionary select = new Dictionary();
  
  
  
  Random randSel= new Random();
  
  
  while(endgame==false)
  {
	  System.out.println("\r\nMAIN MENU\r\n" + 
				"- Start a new Game (N)\r\n" + 
				"- Statistics (S)\r\n" + 
				"- Exit (E)\r\n" + 
				"Please enter your choice:");
	  
	   char answer=input.next().charAt(0);
	   if(answer=='e'|| answer=='E')
	   { endgame=true;}
	    else if (answer=='s'|| answer=='S')
	   
	   { System.out.println("You have played so far " +gamespld+ "games. You have won so far "
	      +gameswon+ "and lost " +gameslost);}
	     
	     
	     else if(answer=='n'|| answer=='N') {
	    	 
	    	 int randn = randSel.nextInt(16)+1;
	    	 String word = select.getWord(randn);
	    	 char[] wordchar = new char[word.length()];
	    	 
	    	 int guessesleft=8;
	    	 //int corrguesses=0;
	    	 //int wrongguesses=0;
	    	 int foundletters=0;
	    	 char guess;
	    	 for(int i=0;i<word.length();i++) {
	    		 
	    		 wordchar[i]='-';
	    	 }
	    	 

	    	 while(guessesleft>0 && foundletters!=word.length())
	    	 {
	    		 boolean rightguess=false;
	    		 System.out.print("\r\nThe random word is now: ");
	    		 for(int i=0;i<word.length();i++) {
	    			 System.out.print(wordchar[i]);
	    		 }
	    		 System.out.println(" You have " +guessesleft+ " left." );
	    		 while(true) {
	    		  System.out.println("Your guess:");
	    		  guess=Character.toUpperCase(input.next().charAt(0));
	    		 if(Character.isLetter(guess)) {
	    			 break;}
	    		 
	    		  
	    			 System.out.println("Wrong input, please insert a Letter");
	    	 }
	    		 
	    	 
	    		 	for(int i=0;i<word.length();i++) {
	    		 		if(word.charAt(i)==guess)
	    		 		{   rightguess=true;
	    		 			foundletters++;
	    		 			wordchar[i]=guess;
	    		 		}
	    	 
	    	 }
	    	 
	    	 if(rightguess==true) {
	    		 System.out.println("The guess is correct!");
	    		 
	    	 }
	    	 else {
	    		 
	    		 System.out.println("There are no " +guess + "'s in the word.");
	    		 guessesleft--;
	    	 }
	    	 
	    	 
	    	 
	    	 }
	    	 if(foundletters==word.length()) {
	    		 gameswon++;
	    		 System.out.println("Congratulations! You guessed the word:"+word);
	    		 System.out.println("You made " +foundletters+ "correct guesses and "+(8-guessesleft)+ "wrong guesses"  );
	    	 }
	    	 else {
	    		 gameslost++;
	    	 }
	    	 
	    	 gamespld++;
	     }
	   
	   
	   
	   
	   
	   
     
	   
	   
	  
	  
	  
	  
	  
  }
input.close();
}

}
