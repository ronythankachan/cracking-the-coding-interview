package chapter1;

import java.util.HashMap;

// Given two strings, write a method to decide if one is a permutation of other
class TwoStringPermutationCheck{
	
	
	// Method1 : This sorts the two string and check if they are equal.
	// This doesn't take any space but the run time is slower. That is O(n log n) to sort.
	static boolean isPermutation1(String str1,String str2) {
		if (str1.length()!=str2.length()) return false;
		char[] sortedStr1 = str1.toCharArray();
		char[] sortedStr2 = str2.toCharArray();
		java.util.Arrays.sort(sortedStr1);
		java.util.Arrays.sort(sortedStr2);
		return new String(sortedStr1).equals(new String(sortedStr2));
	}
	
	// Method2 This will take a hash map of size 2n which O(n) space complexity and O(n) time complexity
	static boolean isPermutation2(String str1,String str2) {
		if(str1.length()!=str2.length()) return false;
		HashMap<Character,Integer> str1Count = getCount(str1);
		HashMap<Character,Integer> str2Count = getCount(str2);
		return isEqual(str1Count,str2Count);
	}
	
	// Method3: This method is slightly better than method2 in terms of practical implementation.
	// Method2 takes 2n space, but this takes only n space and is cleaner.
	static boolean isPermutation3(String str1,String str2) {
		if(str1.length()!=str2.length()) return false;
		int[] charTable = new int[128];
		for(char c:str1.toCharArray()) {
			charTable[c]++;
		}
		for(char c:str2.toCharArray()) {
			charTable[c]--;
			if(charTable[c]<0) return false;
		}
		return true;
	}
	
	static HashMap<Character,Integer> getCount(String phrase){
		HashMap<Character,Integer> charTable = new HashMap<Character,Integer>();
		for(char c: phrase.toCharArray()) {
			if(charTable.get(c) == null) charTable.put(c, 1);
			else charTable.put(c, charTable.get(c)+1);
		}
		return charTable;
	}
	static boolean isEqual(HashMap<Character,Integer> first, HashMap<Character,Integer> second) {
		for(char c: first.keySet()) {
			if (first.get(c) != second.get(c)) return false;
		}
		return true;
	}

	
	
	public static void main(String[] args) {
		
		System.out.println(isPermutation3("abc12","cb2a1"));
		
	}
}