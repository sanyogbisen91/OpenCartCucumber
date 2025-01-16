package practice;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		/*int number = 454;
		int reverse = 0;
		int remainder;
		int temp=number;
		while(number>0)
		{
			remainder = temp%10;
			reverse = reverse*10+ remainder;
			number = number/10;
		}
		if(reverse==temp)
		{
			System.out.println(temp+" is an Palindrome Number");
		}
		else
		{
			System.out.println(temp+" is not an Palindrome Number");
		}

	}*/
		
		 /*int r,sum=0,temp;    
		  int n=454;//It is the number variable to be checked for palindrome  
		  
		  temp=n;    
		  while(n>0){    
		   r=n%10;  //getting remainder  
		   sum=(sum*10)+r;    
		   n=n/10;    
		  }    
		  if(temp==sum)    
		   System.out.println(" palindrome number ");    
		  else    
		   System.out.println(" not palindrome");    
	}*/
		
		/*int num = 12021, reverse = 0, rem, temp;  
		  
	    // palindrome if num and reverse are equal  
	    if (getReverse(num, reverse) == num)  
	     System.out.println (num + " is Palindrome");  
	    else  
	      System.out.println (num + " is not Palindrome");  
	  }  
	//function to reverse the number    
	  static int getReverse(int num, int rev){  
	    if(num == 0)  
	        return rev;      
	    int rem = num % 10;  
	    rev = rev * 10 + rem;  
	    return getReverse(num / 10, rev);  
	}  */
		
		/*// convert these strings to either lowercase or uppercase to create consistency  
        System.out.println(isPalindrome("radar".toLowerCase()));  
        // Naman would not have been palindrome if toLowerCase() method was not used  
        System.out.println(isPalindrome("Naman".toLowerCase()));  
        System.out.println(isPalindrome("12321".toLowerCase()));  
        System.out.println(isPalindrome("12345".toLowerCase()));  
    }  
    private static boolean isPalindrome(String string) {  
        String reversed = new StringBuilder(string).reverse().toString();  
        return string.equals(reversed);  
    }*/  
		
		String original, reverse = ""; // Objects of String class    
	      Scanner in = new Scanner(System.in);     
	      System.out.println("Enter a string/number to check if it is a palindrome");    
	      original = in.nextLine();     
	      int length = original.length();     
	      for ( int i = length - 1; i >= 0; i-- )    
	         reverse = reverse + original.charAt(i);    
	      if (original.equals(reverse))    
	         System.out.println("Entered string/number is a palindrome.");    
	      else    
	         System.out.println("Entered string/number isn't a palindrome.");     
	   }
}
		
	
		  






