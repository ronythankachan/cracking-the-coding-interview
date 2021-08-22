package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CountConstruct {
	
	// Count the number ways to construct a string from a list of words
	public static int countConstruct(String target, ArrayList<String> wordBank) {
		
		if(target.isEmpty()) return 1;
		int count = 0;
		for(String word:wordBank) {
			if(target.indexOf(word) == 0) {
				if(countConstruct(target.substring(word.length()),wordBank)==1) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String target ="leetcode";
		ArrayList<String> wordBank = new ArrayList<String>(Arrays.asList("leet","code","le","et","lee","t","s"));
		System.out.println(CountConstruct.countConstruct(target, wordBank));
	}

}
