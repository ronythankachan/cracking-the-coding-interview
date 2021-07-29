package dynamicprogramming;

public class CanSum {

	public static boolean canSum(int target, int[] nums) {

		if (target < 0)
			return false;
		if (target == 0)
			return true;
		for (int n : nums) {
			boolean can =  canSum(target - n, nums);
			if(can) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] { 4,3 }));
	}
}
