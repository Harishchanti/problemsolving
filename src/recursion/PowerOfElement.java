package recursion;

public class PowerOfElement {

	public static void main(String[] args) {
		double a = 2;
		int n = 3;
		System.out.println(pow(a,n));
	}

	private static double pow(double a, int n) {
		if(n==0) return 1;
		if(n==1) return a;
		double temp = pow(a, n/2);
		return temp*temp*pow(a, n%2);
	}

}
