package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HowSum {

	public static ArrayList<Integer> howSum(int target, ArrayList<Integer> values,
			HashMap<Integer, ArrayList<Integer>> memo) {

		if (memo.containsKey(target))
			return memo.get(target);

		if (target == 0)
			return new ArrayList<Integer>();
		if (target < 0)
			return null;

		for (int value : values) {
			ArrayList<Integer> result = howSum(target - value, values, memo);
			if (result != null) {
				result.add(value);
				memo.put(target - value, result);
				return result;
			}
		}
		memo.put(target, null);
		return null;
	}

	public static void main(String[] args) {
		int target = 300;
		ArrayList<Integer> values = new ArrayList<>(Arrays.asList(7,14));
		HashMap<Integer, ArrayList<Integer>> memo = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> result = HowSum.howSum(target, values, memo);

		if (result == null)
			System.out.println("Unable to obtain sum");
		else
			for (int val : result)
				System.out.println(val);

	}
}
