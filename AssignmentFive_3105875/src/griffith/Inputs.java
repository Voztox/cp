//Mert Faruk GUNES - Computer Science 1st year - 3105875
package griffith;

import java.util.Arrays;
import java.util.Random;

public class Inputs {
	public static void main(String[] args) {
		String[] nameList = {"Napoleon Bonaparte", "Egemen Koku", "Michael D. Higgins", "Mustafa Kemal Ataturk", "Gordon Ramsey"};
		String[] phraseList = 
					{"Science is the most reliable guide in life.", 
					"Impossible is a word to be found only in the dictionary of fools.", 
					"Women love to go out.", 
					
					"My gran could do better.",
					"Winning doesn't always mean being first"};
		//i added the arrays in here to have a better look at them. 
		quoteGenerator(nameList, phraseList);
		//this green texts and () prints to the console.
		success();


		String[] wordList = {"a red","cat","dare","race","care","read","acre"};
		anagramCheck(wordList);

		int[][] numbers = {{32,32,95,95,95,95},
				{32,47,92,95,95,95,92},
				{47,92,32,92,95,95,95,92},
				{92,32,92,47,95,47,95,47},
				{32,92,47,95,47,95,47}};
		asciiDraw(numbers);
	}
	public static void quoteGenerator(String[] nameList, String[] phraseList) { 

		System.out.println("Task One !!");

		String name = nameList[(int) (Math.random() * nameList.length)];
		String phrase = phraseList[(int) (Math.random() * phraseList.length)];
		//math random helps me to choose random phrase and random name

		System.out.println("As the " + name + " once said.");
		System.out.println("'" + phrase + "'" );
		//printing part
	}
	public static void success() {
		Random rand = new Random ();

		System.out.println("Task Two");

		int[] newGrade = new int[50];
		for(int i = 0; i<newGrade.length;i++) {
			newGrade[i] = rand.nextInt(101);
			//this part will give me random 50 integers less than 101 which is between 0 - 100
		}
		for (int i = 0; i < newGrade.length; i++) {
			int maxGrade = i;
			for (int j = i + 1; j < newGrade.length; j++) {
				if (newGrade[j] > newGrade[maxGrade]) {
					maxGrade = j;
					//this part will help for better looking which causes to order them greater to smaller.
				}
			}
			int trying = newGrade[i];
			newGrade[i] = newGrade[maxGrade];
			newGrade[maxGrade] = trying;
		}
		for (int i = 0; i< newGrade.length; i++) {
			System.out.print(newGrade[i] + " ");
			if ((i + 1) % 5 == 0) {
				//for better looking output (5 for each line).
				System.out.println();

			}
		}
		System.out.println("The average grade is: " + average(newGrade));
		System.out.println("The number of failed grades is: " + failed(newGrade));
		//for printing reasons
	}

	public static int average(int[] grades) {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		return sum / grades.length;
		//this part is to just calculate the average grade.
	}
	public static int failed(int[] grades) {
		int failed = 0;
		for (int grade : grades) {
			if (grade < 40) {
				failed++;
			}
		}
		return failed;
		//this part is to just calculate the failed grades
	}

	public static void anagramCheck(String[] words){
		System.out.println("Task Three !! ");
		
		String [] originalWords = new String [words.length];
		for (int i = 0 ; i < words.length ; i++) {
			originalWords[i] = words [i];
			//keeping the original words for printing 
		}

		for(int k = 0 ; k < words.length ; k++) {
			String word = words[k];
			

			int[] ascii = new int[word.length()];
			for (int i = 0 ; i < word.length() ; i++) {
				char asciiChar = word.charAt(i);
				int asciiInt = (int) asciiChar;
				// the first lines will help me to look at each letter one by one (with i). and the last part helps the code to replace it.
				//converting the characters in the words to ascii values
				ascii[i] = asciiInt;
			}
			for (int i = 0; i < ascii.length; i++) {
				int maxAscii = i;
				for (int j = i + 1; j < ascii.length; j++) {
					if (ascii[j] > ascii[maxAscii]) {
						maxAscii = j;
					//sort the array of ascii values in descending order
					}
				}
				int test = ascii[i];
				ascii[i] = ascii[maxAscii];
				ascii[maxAscii] = test;
			}
			String sortedWord = "";
			for(int i = 0; i < ascii.length; i++) {
				int asciiInt = ascii[i];
				char asciiChar = (char) asciiInt;
				sortedWord += asciiChar;
				//converting the sorted array of ascii values back to string

			}
			words[k] = sortedWord;
			//replacing original word with the sorted word in the array of words

			
			for (int i = 0; i < words.length - 1; i++) {
				for (int j = i + 1; j < words.length; j++) {
					if (words[i].equals(words[j])) {
						System.out.println(originalWords[i] + " and " +  originalWords[j] + " are anagrams.");
						//print a message if two words in the array are anagrams of each other.
					}
				}
			}
		}
	}
	public static void asciiDraw(int[][] shape) {
		System.out.println("Task Four !!");

		for (int i = 0 ; i < shape.length; i++) {
			for(int j = 0 ; j < shape[i].length ; j++) {
				int cell = shape [i][j];
				char cellChar = (char) cell;
				System.out.print(cellChar);
			}
			System.out.println();
		}
	}
}

