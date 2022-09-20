package Utilities;

import java.util.Random;

public class Utilities {
	
	public Utilities() {}
	
	Random random = new Random();
	
	/*
	 * This is a utility that generates random string of given length.
	 * The substring is formed by the characters of string str picked randomly
	 */
	public String generateRandomString(String str, int len) {
		String subString = "";
		while(len > 0) {
			subString += str.charAt(random.nextInt(str.length()));
			len--;
		}
		return subString;
	}
	
	/*
	 * This is a utility that removes the spaces.
	 * The spaces before each and every word of the passed string are removed
	 */
	public String trimSpaces(String str) {
		String res = "";
		for(int i = 0; i< str.length();i++) {
			char ch = str.charAt(i);
			if( ch != ' ') {
				res += str.charAt(i);
			}
		}
		return res;
	}

}
