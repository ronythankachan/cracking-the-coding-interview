package chapter1;

import java.util.HashMap;

// Algorithm to check if all the characters in a string are unique

class UniqueCharacters{
	
	// Method1 that takes O(n) space and time complexity
	static boolean isUnique1(String phrase) {
		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		for(char c:phrase.toCharArray()) {
			if (charCount.get(c) != null) return false;
			else charCount.put(c, 1);
		}
		return true;
	}
	// Method2 will take up space of 128 characters if its ASCII which is O(1) space complexity
	// and O(n) time complexity
	static boolean isUnique2(String phrase) {
		if (phrase.length()>128) {
			return false;
		}else {
			int[] count = new int[128];
			for (char c:phrase.toCharArray()) {
				if(count[c]> 0) return false;
				else count[c]+=1;
			}
		}
		return true;
	}
	// Method3 using bit operators assuming that only small letters are there.
	// It will take O(1) space complexity and O(n) time complexity.
	static boolean isUnique3(String phrase) {
		int checker = 0;
		for (char c:phrase.toCharArray()) {
			int val = c-'a';
			if((checker & (1 << val)) >0) {
				return false;
			}
			else checker |= 1 << val;
		}
		return true;
	}
	
	// Here BCR is O(n). It cannot be lower than that.
	public static void main(String[] args) {
		System.out.println(isUnique1("abcd123"));
		System.out.println(isUnique2("abcdxfea"));
		System.out.println(isUnique3("abcd"));
	}
}