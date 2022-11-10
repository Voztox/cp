//Name: Mert Faruk Gunes, ID: 3105875, Date: 10/30/2022
package griffith;
import java.util.Scanner;
public class Calculations {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Part Two Task One");
		System.out.println("Enter the two shorter sides of the triangle");
		double sideOne = input.nextDouble();
		double sideTwo = input.nextDouble();
		// We ask users to input a Doubles so we can calculate the hypotenuse
		final double total = sideOne*sideOne + sideTwo*sideTwo;
		double root = Math.sqrt(total);
		// math.sqrt helps us to get the root of the product
		double roundedroot = Math.round(root * 100.0) / 100.0;
		//with rounded element we round our result to 2 decimal spaces
		System.out.println("The hypotenuse is " + roundedroot);
		
		System.out.println("-----------------");
		System.out.println("Part Two Task Two");
		
		
		System.out.println("Enter two times in 24hr format");
		double hourOne = input.nextDouble();
		double hourTwo = input.nextDouble();
		
		double subs= hourOne - hourTwo;
		double hours = Math.abs(subs);
		//with math.abs we can always get positive result from equalution
		double roundedhours = Math.round(hours * 100.0) / 100.0;
		double mins = roundedhours*60;
		//converting hours to minutes
		double roundedmins = Math.round(mins * 100.0) / 100.0;
		//converting minutes to seconds
		double seconds = mins*60;
		double roundedseconds = Math.round(seconds * 100.0) / 100.0;
		//with rounded element we round our result to 2 decimal spaces
		
		System.out.println("There are " + roundedhours + " hours in between " + hourOne + " and " + hourTwo);
		System.out.println("There are " + roundedmins + " minutes in between " + hourOne + " and " + hourTwo);
		System.out.println("There are " + roundedseconds + " seconds in between " + hourOne + " and " + hourTwo);
		
	}

}
