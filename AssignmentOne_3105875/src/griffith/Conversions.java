//Name: Mert Faruk Gunes, ID: 3105875, Date: 10/30/2022
package griffith;
import java.util.Scanner;
public class Conversions {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Part one Task One");
		System.out.println("Enter amount in foot");
		double feet = input.nextDouble();
		// We ask users to input a value 
		final double  RATE = 0.3048;
		double meters = feet* RATE;
		// With the value we make the math here
		double roundedmt = Math.round(meters * 100.0) / 100.0;
		//with rounded element we round our result to 2 decimal spaces 
		System.out.println(feet + "ft is "  + roundedmt + " m"  );
		
		System.out.println("------------------");
		System.out.println("Part one Task Two");
		
		System.out.println("Enter the amount of positions to shift");
		int pos = (int) input.nextInt();
		// We ask users to input a number to shift
		System.out.println("Enter the character to encode");
		char c;
		c = input.next().charAt(0);
		// We ask users to input a char to encode 
		int ascii_user = (int)c;
		// we can convert letters to values on ASCII so we can do the math
		int pos_ascii_user = ascii_user - 'a';
		int final_ascii = pos_ascii_user + pos;
		System.out.println(c + " encoded is " + (char)(final_ascii + 'a'));
		
		
		System.out.println("------------------");
		
		System.out.println("Part one Task Three");
		System.out.println("Enter the room width and length in meters");
		double width = input.nextDouble();
		double length = input.nextDouble();
		// We ask users to input a Doubles so we can calculate the square of the room
		final double RATE2 = 1.19599; 
		final double price = 20.35;
		double sqr = width*length;
		double conv = width*length*RATE2*price;
		// On here we make the math for the calculation for the final price
		double roundedconv = Math.round(conv * 100.0) / 100.0;
		double roundedsqr= Math.round(sqr * 100.0) / 100.0;
		//with rounded element we round our result to 2 decimal spaces 
		System.out.println("The carpet is €" + roundedconv + " for " + roundedsqr + " square meter at €20.35 per square yard" );
		
		System.out.println("------------------");
		
	}

}
