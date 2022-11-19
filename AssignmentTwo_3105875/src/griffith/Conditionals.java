//Mert Faruk Gunes, 3105875
package griffith;

import java.util.Scanner;
import java.util.Random;

public class Conditionals {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("Assignment Two Part One Task One");

		System.out.println("Enter your height in meters and your weight in kilograms");

		double height = input.nextDouble();
		double weight = input.nextDouble();
		final double bmi = weight / (height * height);

		if (bmi < 18.5) {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are underweight");
		}

		else if (bmi < 25) {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are normal");
		} else if (bmi < 30) {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are overweight");
		} else if (bmi < 35) {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are Obese (Class I) ");
		} else if (bmi < 40) {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are Obese (Class II) ");
		} else {
			System.out.println("Your bmi is " + (Math.round(bmi)) + " you are extreme Obese");
		}

		System.out.println("--------------------------------");
		System.out.println("Assignment Two Part One Task Two");

		System.out.println("Enter the amount of positions to shift");
		int amount = input.nextInt();
		System.out.println("Enter a word to shift");
		String word = input.nextLine();
		word = input.nextLine();

		String ciphertext = "";

		char alphabet;
		for (int i = 0; i < word.length(); i++) 
		{
			alphabet = word.charAt(i);

			if (alphabet >= 'a' && alphabet <= 'z') 
			{
				alphabet = (char) (alphabet + amount);
				if (alphabet > 'z') {
					alphabet = (char) (alphabet + 'a' - 'z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			}

			else if (alphabet >= 'A' && alphabet <= 'Z') {
				alphabet = (char) (alphabet + amount);
				if (alphabet > 'Z') {
					alphabet = (char) (alphabet + 'A' - 'Z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			} else {
				ciphertext = ciphertext + alphabet;
			}

		}
		System.out.println(ciphertext);

		System.out.println("Assignment Two Part One Task Three");
		System.out.println("--------------------------------");

		System.out.println("Enter a number between 1 and 20");
		long num = input.nextLong();
		// after 20 long element does not help me and the number converts to negative
		// that's why i used BigInteger

		while (num < 0 || num > 20) 
		{
			if (num < 0) {
				System.out.println("Positive numbers only");
				System.out.println("Try again between 1-20");
				num = input.nextLong();
				// is BigInteger allowed?
			} else if (num > 20) {
				System.out.println("Too large to print");
				System.out.println("Try again between 1-20");
				num = input.nextLong();
			}

		}

		long fact = 1;
		for (int i = 1; i <= num; i++) 
		{
			fact = fact * i;
		}
		System.out.println("The factorial of " + num + " is " + fact);

		System.out.println("Assignment Two Part One Task Four");
		System.out.println("--------------------------------");

		System.out.println("Choose your difficulty with numbers between 'easy(1) - hard(2) - easy elimination(3) - hard elimination(4)'");
		int difficulty = input.nextInt();
		String[] operations = { "+", "-", "*" };
		int minOp = 0;
		int maxOp = 3;
		int count = 10;
		int score = 0;
		int firstNum;
		int secondNum;
		boolean elimination = false;
		switch (difficulty) 
		{
		case 3:
			elimination = true;
		case 1:
			count = 10;
			break;
		case 4:
			elimination = true;
		case 2:
			count = 100;
			break;
		default:
			System.out.println("Not a valid number of difficulty. Please Try again between 1-4...");
			difficulty = input.nextInt();
		}
		if (elimination) {
			int counter = 0;
			while (elimination == true) 
			{

				counter++;
				int operation = (int) ((Math.random() * (maxOp - minOp)) + minOp);
				int rngOne = rand.nextInt((count) + 1);
				int rngTwo = rand.nextInt((count) + 1);

				if (rngTwo > rngOne) 
				{
					firstNum = rngTwo;
					secondNum = rngOne;
				} else 
				{
					firstNum = rngOne;
					secondNum = rngTwo;
				}

				System.out.println("Question " + counter + " what is " + firstNum + operations[operation] + secondNum + " = ");
				int solution = operation == 0 ? (firstNum) + (secondNum) : operation == 1 ? (firstNum) - (secondNum) : operation == 2 ? (firstNum) * (secondNum) : 0;
				int answer = input.nextInt();

				if (solution == answer) 
				{
					score++;
					continue;
				} 
				else 
				{
					System.out.println("Whoops...  You got " + score + " questions correct. Better Luck next time!");
					break;
				}

			}
		} 
		else
		{
			for (int i = 0; i < 10; ++i) {
				int operation = (int) ((Math.random() * (maxOp - minOp)) + minOp);
				int rngOne = rand.nextInt((count) + 1);
				int rngTwo = rand.nextInt((count) + 1);

				if (rngTwo > rngOne) {
					firstNum = rngTwo;
					secondNum = rngOne;
				} else {
					firstNum = rngOne;
					secondNum = rngTwo;
				}

				System.out.println("Question " + (i + 1) + " what is " + firstNum + operations[operation] + secondNum + " = ");
				int solution = operation == 0 ? (firstNum) + (secondNum) : operation == 1 ? (firstNum) - (secondNum) : operation == 2 ? (firstNum) * (secondNum) : 0;
				int answer = input.nextInt();
				if (solution == answer) {
					score++;
				}

			}
			System.out.println("Congrats you got " + score + "/10 correct answers");
		}
	}
}
