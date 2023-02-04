package griffith;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean newGame = true;
		final int MAX_WRONG_GUESSES = 7;
		String[] wordListEng = {"hello", "world", "java", "programming", "computer"};
		String[] wordListTr = {"selam", "gezegen", "okul", "bilgisayar", "bilim"};
		//we make lists here for making language selection.
		int total = 0;
		int wins = 0;
		//introducing the counters.
		while(newGame) {
			//this is a loop incase the player wants to play again.
			String[] wordList= {};
			int lang;
			do {
				System.out.println("Type 1 for English words.");
				System.out.println("Type 2 for Turkish words.");
				lang = input.nextInt();
				input.nextLine();
				//code is going to use wordList as a data. 
			}while (lang > 2 || lang <= 0);
			if(lang == 1) {

				wordList = wordListEng;
			}
			else if (lang == 2) {
				wordList = wordListTr;
			}

			String word = wordList[(int) (Math.random() * wordList.length)];
			String unfinishedWord = "";
			String printedWord = "";
			//we create a new string because unfinished word seems longer with spaces than usual word. Which causes problem on progress.
			//this string is only created for printing.


			for (int i = 0; i < word.length(); i++) {
				unfinishedWord += "_";
				//this loop basically going to help to the showing the letters as underscore. 
			}

			int currentGuess = 0;
			//introducing the guess data
			String guessData = "";

			while (currentGuess < MAX_WRONG_GUESSES && unfinishedWord.contains("_")) {
				printedWord = "";
				for(int i = 0; i < unfinishedWord.length(); i++) {
					printedWord += unfinishedWord.charAt(i) + " ";
				}
				System.out.println("Word: " + printedWord);
				System.out.println("Guesses: " + guessData);
				System.out.println("Guesses left: " + (MAX_WRONG_GUESSES - currentGuess));
				//this part is to show the table every time user makes a guess.
				System.out.print("Enter a letter: ");
				String guess = input.nextLine();
				if (guess.length() != 1) { 
					System.out.println("Enter a single letter.");
					continue;
					//basically a error catch. incase the user inputs longer than 1 letter
				}
				char letter = guess.charAt(0);
				if (guessData.contains(guess)) {
					continue;
				}
				if (word.contains(guess)) {
					String newWord = "";
					for (int i = 0; i < word.length(); i++) {
						//in this loop code is checking and replacing. In other words playing the game.
						if(word.charAt(i) == unfinishedWord.charAt(i)){
							newWord += word.charAt(i);

							continue;
						}
						if(word.charAt(i) == letter) {
							newWord += letter;
						}
						else {
							newWord += "_";
						}
					}
					unfinishedWord = newWord;	
				}
				else {
					currentGuess++;
					//keeping the track of guesses.
				}

				guessData += " " + letter ;

				printHangman(currentGuess);	
				//this was to do draw hangman. I had no any better idea than drawing one by one for each wrong guess.
				//i had the idea of making a base template of the pole. However, It couldn't make it any shorter so i kept it that way.
			}
			total++;
			if (unfinishedWord.equals(word)) {
				wins++;
				//win counter here and total game counter on top.
				System.out.println("You won!");
			} else {
				System.out.println("You lost. The word was " + word);
			}
			System.out.println("Your score is " + wins + " / " + total); 	
			System.out.println("Please type 0 to play again.");
			int game = input.nextInt();
			input.nextLine();
			if(game == 0) {
				newGame = true;
			}
			else {
				newGame = false;
				System.out.println("It was a pleasure to play with you!");
				//with this condition 
			}
		}
	}



	private static void printHangman(int currentGuess) {
		if (currentGuess == 0) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    ");
			System.out.println("  |    ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}if (currentGuess == 1) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 2) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 3) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |   /");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 4) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |   /|");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 5) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |   /|\\ ");
			System.out.println("  |  ");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 6) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |   /|\\ ");
			System.out.println("  |   /");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
		if (currentGuess == 7) {
			System.out.println("   _ _ _  ");
			System.out.println("  |    |");
			System.out.println("  |    O");
			System.out.println("  |   /|\\ ");
			System.out.println("  |   / \\");
			System.out.println("  |  ");
			System.out.println("__|__");
		}
	}

}
