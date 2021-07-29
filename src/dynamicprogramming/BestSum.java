package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class BestSum {

	public static ArrayList<Integer> bestSum(int target, ArrayList<Integer> values) {

		if (target == 0)
			return new ArrayList<Integer>();

		if (target < 0)
			return null;

		ArrayList<Integer> bestPath = null;

		for (int num : values) {

			ArrayList<Integer> result = bestSum(target - num, values);
			if (result != null) {
				result.add(num);
				if (bestPath == null || result.size() < bestPath.size()) {
					bestPath = result;
				}
			}
		}
		return bestPath;
	}

	public static void main(String[] args) {
		int target = 7;
		ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(4, 5));
		ArrayList<Integer> result = BestSum.bestSum(target, values);
		if (result == null)
			System.out.println("Unable to find sum");
		else
			for (int num : result)
				System.out.println(num);

	}

}
