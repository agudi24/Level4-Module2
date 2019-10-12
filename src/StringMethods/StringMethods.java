package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return s2;
		}
		return s1;
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		String newString = "";
		if (s.contains("underscores")) {
			for (int i = 0; i < s.length(); i++) {
				String sub = s.substring(i, i + 1);
				if(sub.equals(" ")) {
					sub = sub.replace(" ", "_");
				}
				newString += sub;
			}
			return newString;
		}
		else {
			return s;
		}

	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String[] str1 = s1.split(" ");
		String[] str2 = s2.split(" ");
		String[] str3 = s3.split(" ");
		Character c1 = str1[1].charAt(0);
		Character c2 = str2[1].charAt(0);
		Character c3 = str3[1].charAt(0);
		System.out.println(str1[1].charAt(0));
		System.out.println(str2[1].charAt(0));
		System.out.println(str3[1].charAt(0));
		if(c1.compareTo(c2) < 0 && c1.compareTo(c3) < 0) {
			return s1;
		}
		if(c2.compareTo(c1) < 0 && c2.compareTo(c3) < 0) {
			return s2;
		}
		if(c3.compareTo(c1) < 0 && c3.compareTo(c2) < 0) {
			return s3;
		}
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		int c;
		for (int i = 0; i < s.length(); i++) {
		if(s.charAt(i) == (int)s.charAt(i)) {
			c = (int)s.charAt(i);
			sum = sum + c;
		}
		else {
			c = Character.getNumericValue(s.charAt(i));
			sum = sum + c;
		}
		}
		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int times = 0;
		if(s.contains(substring)) {
			times++;
		}
		for (int i = 0; i < s.length(); i++) {
			
		}
		return times;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] b = s.getBytes();
		byte a = (byte)key;
		String encryption = Utilities.encrypt(b, a);
		return encryption;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		byte b = (byte)key;
		String decryption = Utilities.decrypt(s, b);
		return decryption;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int distanceS = s.length();
		int distanceSubstring = substring.length();
		return (distanceS - (distanceSubstring * 2));
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
