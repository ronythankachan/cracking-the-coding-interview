package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CanConstruct {
	
	public static boolean canConstruct(String target, ArrayList<String> wordBank) {
		
		if(target.isEmpty()) return true;
		
		for(String word:wordBank) {  
			if(target.indexOf(word)==0) {
				if(canConstruct(target.substring(word.length()),wordBank)) {
					return true;
				}
			}
			else if(target.indexOf(word)>0 && target.indexOf(word) == target.length()-word.length()) {
				if(canConstruct(target.substring(0,target.length()-word.length()),wordBank)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String target ="leetcode matches";
		ArrayList<String> wordBank = new ArrayList<String>(Arrays.asList("leet","code","le","de"," ","matche","s"));
		System.out.println(CanConstruct.canConstruct(target, wordBank));
	}
}
