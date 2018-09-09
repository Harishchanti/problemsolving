package array;

public class Test {
    public static void main(String args[])
    {
        int a[] = {10,1,10,1,10,1,10};
        int t = 50;
        System.out.print(solve(a,t));
    }

    private static int solve(int[] a, int t) {

        int out= 0;
        int sum = 0;

        for(int i = 0 ;i < a.length; i++) {
            sum += a[i];

            if(a[i]!= 0) {
                out = i;
            }
            if(sum >= t) {
                out = i;
                break;
            }
        }
        return  out+1;
    }
} 