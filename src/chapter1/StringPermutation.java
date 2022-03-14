package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPermutation {

	/*
	 * Lets take an example "abc". To find the permutations in an array,
	 * permutation("abc") 
	 * 		c = 'a'
	 * 		permutation("bc")
	 * 			c= 'b'
	 * 			permutation("c")
	 * 				returns ["c"]
	 * 			insert b to every position of each element of array. ie, 'bc' and 'cb'
	 * 			returns ['bc','cb]
	 * 		insert 'a' to every position of each element of array. ie, abc, bac, bca, acb, cab, cba
	 * 		return [abc, bac, bca, acb, cab, cba]
	 *
	 */
	static ArrayList<String> permutation(String str){
		ArrayList<String> result = new ArrayList<>();
		if(str.length()==1)
			return new ArrayList<String>(Arrays.asList(str));
		char c = str.charAt(0);
		ArrayList<String> perms = permutation(str.substring(1)); //[c]
		for(int i=0;i<perms.size();i++) {
			String temp = perms.get(i);
			for(int j=0;j<temp.length();j++) {
				result.add(temp.substring(0,j)+c+temp.substring(j));
			}
			result.add(temp+c);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> result = StringPermutation.permutation("abcd");
		System.out.println(result.size());
		for(String str:result) {
			System.out.println(str);
		}
	}
	
}
