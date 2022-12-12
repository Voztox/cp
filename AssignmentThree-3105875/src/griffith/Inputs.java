// Mert Faruk Gunes - 3105875 - 
package griffith;

import java.util.Formatter;
import java.util.Scanner;

public class Inputs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Formatter formatter = new Formatter();

		System.out.println("Assignment Three Part One");
		int num, digit, sum;
		num = 0;
		digit = 0;
		sum = 0;
		//introducing the elements first
		boolean valid = false;
		//adding the validating system.
		while (valid == false)
		{
			System.out.println("Enter number");
			try 
			{
				num = Math.abs(input.nextInt());
				//we added abs to fix negative numbers sum.
				valid = true;
			} catch (Exception error) 
			//catch helps us to input only numbers.
			{
				System.out.println("Only Numbers!");
			}
			input.nextLine();
			// This is used to consume the new line character
		}

		while (num > 0) 
		{
			digit = num % 10;
			sum = sum + digit;
			num = num / 10;
			//doing the calculating to find the result
		}
		System.out.println("Sum of Digits: " + sum);

		System.out.println("Assignment Three Part Two");
		System.out.println("Enter Max Value to Convert");
		final double poundMultiplier = 2.2f;
		final double ounceMultiplier = 35.27f;
		//introducing the rates and other values
		int maxValue = 0;
		boolean validTwo = false;
		//validating the input
		while (validTwo == false) 
		{
			try {
				maxValue = input.nextInt();
			} catch (Exception error) 
			//this helps me to input only numbers.
			{
				System.out.println("max number has to be numeric. try again.");
				input.nextLine();
				continue;
			}
			input.nextLine();
			if (maxValue < 1) 
			//this helps me to avoid negative numbers
			{
				System.out.println("max number has to higher than 0. try again.");
			} else 
			{
				validTwo = true;
			}
		}
		formatter.format("%s | %s |  %s\t |\n", "Kilograms", "Pounds", "Ounces");
		//using formatter to make a table on console.

		for (int i = 0; i < maxValue; ++i) {
			int kilo;
			double pounds, ounces;
			//doing the calculation.
			kilo = i + 1;
			pounds = kilo * poundMultiplier;
			ounces = kilo * ounceMultiplier;

			formatter.format("%9d | %6.2f | %6.2f\t |\n", kilo, pounds, ounces);
		}

		System.out.println(formatter);

		System.out.println("Assignment Three Part Three");
		System.out.println("Enter a password");
		final int MIN = 8;
		final int MIN_UPPER = 1;
		final int MIN_LOWER = 1;
		final int DIGITS = 2;
		final int MIN_SPECIAL = 1;
		//introducing the conditions 
		boolean passValid = false;
		
		while (passValid == false) {
			String password = input.nextLine();
			int upperCount = 0;
			int lowerCount = 0;
			int digitCount = 0;
			int specialCount = 0;
			//introducing the elements

			for (int i = 0; i < password.length(); i++) 
			{
				char c = password.charAt(i);
				//checking characters one by one.
				if (Character.isUpperCase(c)) 
				{
					upperCount++;
				}
				if (Character.isLowerCase(c)) 
				{
					lowerCount++;
				}
				if (Character.isDigit(c)) 
				{
					digitCount++;
				}

				if (c >= 35 && c <= 38) 
				{
					specialCount++;
				}
			}
			if (password.length() >= MIN && upperCount >= MIN_UPPER && lowerCount >= MIN_LOWER && digitCount >= DIGITS && specialCount >= MIN_SPECIAL) 
			{
				System.out.println("Password Succesful");
				break;
			} 
			else 
			{
				System.out.println("Password Unsuccesful");
				System.out.println("Missing contains of the password are listed below");

			}
			if (password.length() < MIN) 
			{
				System.out.println("Password must be longer than 8 characters.");
			}
			if (upperCount < MIN_UPPER) 
			{
				System.out.println("Password must contain at least 1 uppercase letter.");
			}
			if (lowerCount < MIN_LOWER) 
			{
				System.out.println("Password must contain at least 1 lowercase letter.");
			}
			if (specialCount < MIN_SPECIAL) 
			{
				System.out.println("Password must contain at least 1 special character.");
			}
			if (digitCount < DIGITS) 
			{
				System.out.println("Password must contain at least 2 digits");
			}
			//output is the result of what the input is missing

		}
		System.out.println("Assignment Three Part Four");
		System.out.println("Enter your name");
		String name = input.nextLine();
		System.out.println("Enter your age");
		int age = input.nextInt();
		while (age < 0 || age > 130) 
		//basically making sure if they are human
		{
			if (age < 0) 
			{
				System.out.println("Age can not be negative");
				System.out.println("Try again ");
				age = input.nextInt();
			} else if (age > 130) 
			{
				System.out.println("You can not be that old");
				System.out.println("Try again ");
				age = input.nextInt();
			}
		}
		//we use mod for ordinals but 11, 12, and 13 is exceptional so added them to if.
		if (age % 10 == 1 && age != 11) 
		{
			System.out.println("Happy " + age + "st birthday " + name);
		} 
		else if (age % 10 == 2 && age != 12) 
		{
			System.out.println("Happy " + age + "nd birthday " + name);
		} 
		else if (age % 10 == 3 && age != 13) 
		{
			System.out.println("Happy " + age + "rd birthday " + name);
		} 
		else 
		{
			System.out.println("Happy " + age + "th birthday " + name);
		}

		System.out.println("Assignment Three Part Five");

		System.out.println("Enter rows");
		int rows = input.nextInt();
		System.out.println("Enter your columns");
		int columns = input.nextInt();

		for (int i = 0; i <= rows; i++) 
		{
			for (int j = 0; j < columns; j++) 
			{
				if (i == 0)
					System.out.print(" _");
				else
					System.out.print("|_");
			}
			if (i > 0)
				System.out.println("|");
			else
				System.out.println("");

		}
		//what we do on this task is asking users for inputs to make rows and columns. first we add the cap with " _" then. we do the rest with filling "|_". 

	}

}
