package dynamicprogramming;

import java.util.HashMap;

public class GridTraveller {

	// Return the number of ways to travel through an n*m grid.
	// Can only move right or down.
	public static int travelGrid(int n, int m, HashMap<String,Integer> memo) {
		String keyPair = n+","+m;
		String revKeyPair = m+","+n;
		if(memo.containsKey(keyPair)) return memo.get(keyPair);
		if(memo.containsKey(revKeyPair)) return memo.get(revKeyPair);
		if(n==1 && m==1) return 1;
		if (n==0 || m==0) return 0;
		memo.put(keyPair, travelGrid(n-1,m,memo)+travelGrid(n,m-1,memo));
		return memo.get(keyPair);
	}

	public static void main(String[] args) {
		HashMap<String,Integer> memo = new HashMap<String,Integer>();
		System.out.println(GridTraveller.travelGrid(2, 3,memo));
	}
}

