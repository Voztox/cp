//Mert Faruk Gunes, 3105875
package griffith;
import java.util.Scanner;
import java.io.InputStream;
import java.lang.Math;
public class Conditionals {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

	System.out.println("Assignment Two Part One Task One");	
	
	System.out.println("Enter your height in meters and your weight in kilograms");
	
	double height = input.nextDouble();
	double weight = input.nextDouble();
	final double bmi = weight/(height*height);
	
	if (bmi < 18.5) {
		System.out.println("Your bmi is " + (Math.round(bmi)) + " you are underweight");
	}
		
	else if  ( bmi < 25 ) {
		System.out.println("Your bmi is " + (Math.round(bmi)) + " you are normal");
	}
	else if  ( bmi < 30 ) {
		System.out.println("Your bmi is " + (Math.round(bmi)) + " you are overweight");
	}
	else if  ( bmi < 35 ) {
		System.out.println("Your bmi is " + (Math.round(bmi)) + " you are Obese (Class I) ");
	}
	else if  ( bmi < 40 ) {
		System.out.println("Your bmi is " + (Math.round(bmi)) + " you are Obese (Class II) ");
	}
	else {
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
		for(int i=0; i < word.length();i++) 
		{
			alphabet = word.charAt(i);
			
			if (alphabet >= 'a' && alphabet <='z')
			{
				alphabet = (char)(alphabet + amount);
				if (alphabet > 'z') 
				{
					alphabet = (char) (alphabet + 'a'-'z'-1);
				}
				ciphertext = ciphertext + alphabet;
			}
			
			else if(alphabet >= 'A' && alphabet <= 'Z') {   
	             alphabet = (char) (alphabet + amount);       
	             if(alphabet > 'Z') {
	                 alphabet = (char) (alphabet+'A'-'Z'-1);
	             }
	             ciphertext = ciphertext + alphabet;
	            }
	            else {
	             ciphertext = ciphertext + alphabet;   
	            }
	        
	    }
	    System.out.println(ciphertext);
	

	System.out.println("Assignment Two Part One Task Three");
	System.out.println("--------------------------------");	
	
	System.out.println("Enter a number between 1 and 25");
	long num = input.nextLong();
	//after 20 long element does not help me and the number converts to negative that's why i used BigInteger
	
	while (num < 0 || num > 25)
	{
		if (num < 0)
		{
			System.out.println("Positive numbers only");
			System.out.println("Try again between 1-25");
			num = input.nextLong();
			// is BigInteger allowed? 
		}
		else if (num > 25)
		{
			System.out.println("Too large to print");
			System.out.println("Try again between 1-25");
			num = input.nextLong();
		}
		
	}
		
	long fact = 1;
	for (int i=1; i <= num; i++)
	{
		fact=fact*i;
	}
	System.out.println("The factorial of " + num + " is " + fact);
	
	System.out.println("Assignment Two Part One Task Four");
	System.out.println("--------------------------------");	
	
	System.out.println("Choose your difficulty with numbers between 'easy(1) - hard(2) - easy elimination(3) - hard elimination(4)'");
	int difficulty = input.nextInt();
	switch (difficulty) 
	{
	case 1: 
		System.out.println("You have choosen the easy mode");
        String[] operations = {"+", "-", "*", "/"};
        int minOp = 0;
        int maxOp = 3;
        operations = (Math.random()*(maxOp-minOp)) + minOp;
        
        switch (difficulty) 
        {
        case 1: 
            System.out.println("You have choosen the easy mode");
            int min1 = 1;
            int max1 = 10;
            
            for(int i = 0; i < 10; i++) 
            {
                int rngOne = (int) (Math.random()*(max1-min1)) + min1;
                int rngTwo = (int) (Math.random()*(max1-min1)) + min1;
                
                System.out.println(rngOne + operations[operation] +  rngTwo);
                
                
            }
            break;
	
	case 2: 
		System.out.println("You have choosen the hard mode");
		int min2 = 1;
        int max2 = 10;
		
		for(int i = 0; i < 10; i++) 
		{
			int rngOne = (int) (Math.random()*(max2-min2)) + min2;
			int rngTwo = (int) (Math.random()*(max2-min2)) + min2;
            System.out.println(rngOne +  +  rngTwo);
		}
		break;
	case 3: 
		System.out.println("You have choosen the easy elimination mode");
		int min3 = 1;
        int max3 = 10;
		
		for(int i = 0; i < 10; i++) 
		{
			int rngOne = (int) (Math.random()*(max3-min3)) + min3;
			int rngTwo = (int) (Math.random()*(max3-min3)) + min3;
            System.out.println(rngOne +  +  rngTwo);
		}
		break;
	case 4: 
		System.out.println("You have choosen the hard elimination mode");
		int min4 = 1;
        int max4 = 10;
		
		for(int i = 0; i < 10; i++) 
		{
			int rngOne = (int) (Math.random()*(max4-min4)) + min4;
			int rngTwo = (int) (Math.random()*(max4-min4)) + min4;
            System.out.println(rngOne +  +  rngTwo);
		}
		break;
	default:
		System.out.println("Not a valid number of difficulty. Please Try again between 1-4...");
		difficulty = input.nextInt();
		
	}
	
	
	
	
	
	}

}
