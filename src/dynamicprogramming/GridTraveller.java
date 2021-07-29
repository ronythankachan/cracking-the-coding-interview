package dynamicprogramming;

public class GridTraveller {

	
	public static int travelGrid(int n, int m) {
		
		if(n==1 && m==1) return 1;
		if (n==0 || m==0) return 0;
		return travelGrid(n-1,m)+travelGrid(n,m-1);
	}

	public static void main(String[] args) {
		System.out.println(GridTraveller.travelGrid(2, 3));
	}
}

