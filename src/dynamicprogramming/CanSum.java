package dynamicprogramming;

import java.util.HashMap;

public class CanSum {

	// Check if the array values can form a target sum
	public static boolean canSum(int target, int[] nums, HashMap<Integer,Boolean> memo) {
		
		if(memo.containsKey(target)) return memo.get(target);
		if (target < 0) return false;
		if (target == 0) return true;
		for (int n : nums) {
			boolean isPossible = canSum(target - n, nums,memo);
			if(isPossible) {
				memo.put(target-n, true);
				return true;
			}
		}
		memo.put(target, false);
		return false;
	}

	public static void main(String[] args) {
		HashMap<Integer,Boolean> memo = new HashMap<Integer,Boolean>();
		System.out.println(canSum(300, new int[] { 1,2,3,4 },memo));
	}
}
