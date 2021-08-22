package dynamicprogramming;

import java.util.HashMap;

public class Fib {
	
	// Return the nth fibonacci number
	public static Long fib(Long n,HashMap<Long,Long> memo) {
		if(n<=2) return 1L;
		if(memo.containsKey(n)) return memo.get(n);
		memo.put(n, fib(n-1,memo)+fib(n-2,memo));
		return memo.get(n);
	}

	public static void main(String[] args) {
		HashMap<Long,Long> memo = new HashMap<Long,Long>();
		System.out.println(Fib.fib(100L, memo));
	}
}
