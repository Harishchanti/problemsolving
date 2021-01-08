package leetcode_medium;

public class TotalNumberOfHillAndVally {

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};// 4
        //[-1, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, -1];
        //[-1, -1, -1, -1, 4, 4, 4,4, 4, 4, 4, -1];

        int[] b = {-3, -3};

        int[] n = {6,1,4,6,3,2,7,4};
        int k=2,l=1;
        int max = subSetSumOfLength(n,k);
        int maxL = subSetSumOfLength(n,l);
        //return max + maxL;
        //System.out.println(count(a));
    }

    private static int  subSetSumOfLength(int[] a, int k) {
        int max = -1;
        for(int i = 0;i< a.length;i++) {
            for (int j = i+1;j<a.length-1;j++) {
                if(j-i == k) {
                    int m = findSum(a,i,j);
                    if(max <m) max =m;
                } else if(j-i > k){
                    break;
                }
            }
        }
        return max;
    }

    private static int findSum(int[] a, int i, int j) {
        int sum =0;
        for(int h=i;h<=j;h++) sum +=a[h];
        return sum;
    }

    private static int count(int[] a) {
        /*int count = 0;
        //int pre = Integer.MAX_VALUE;
        int cur = Integer.MAX_VALUE;
        int h = 0, v = 0, i = 0;
        int pre = a[0];

        for (i = 1; i < a.length - 1; i++) {
            if (pre < a[i] && a[i] > a[i + 1]) h++;

            pre = a[i];
        }
        if (a[a.length - 1] > pre) h++;


        System.out.println(h);

        pre = a[0];
        int curret = pre;

        for (i = 1; i < a.length - 1; i++) {
            int next = a[i];
            if (pre > curret && curret < next) v++;

            pre = a[i];

        }
        if (a[a.length - 1] < pre) v++;
        System.out.println(v);*/
        //if not s or len (s) < 2:
        //return 0
        if(a.length < 2) return 0;

        int i = 0;
        int count = 0;
        int pre = Integer.MAX_VALUE;

        while (i < a.length) {
            if(i == 0) {
                while ((i+1) < a.length && a[i] == a[i+1]) i+=1;
                i +=1;
                if( i <= a.length) {
                    count +=1;
                    pre = a[i-1];
                }

            } else if( i == a.length - 1) {
                while (a[i] == a[i-1]) i -=1;

                i -=1;
                if(i >=0) {count +=1; break;}
            } else  {
                while ( (i+1) < a.length  && a[i] == a[i+1]) i +=1;
                i+=1;
                if(a[i] > a[i-1] && pre > a[i-1]) count +=1;
                else if(a[i] < a[i-1] && pre < a[i-1] ) count +=1;
                pre = a[i-1];

            }
        }
        //return count;
/*
        for(int i = 0;i<a.length;i++) {
            if(cur == Integer.MAX_VALUE) {
                cur = a[i];
            } else {
                if(a[i] != cur) {
                    if(pre != Integer.MAX_VALUE) {
                        if(pre < cur && a[i] < cur) {
                            count +=1;
                        }
                    }else {
                        pre = cur;
                        count += 1;
                    }
                    pre = cur;
                    cur = a[i];
                }
            }
        }
        if(pre !=cur) count +=1;*/
        /*int i = 0;
        int prev = a[0];
        int v=0;
        for( i=1 ;i <a.length-1;i++) {
            if(prev > a[i] && a[i] < a[i+1]) v++;

            prev = a[i];
        }
        System.out.println(v);
        int f = a[0];
        int h = 0;
        for( i=1 ;i <a.length-1;i++) {
            if(prev < a[i] && a[i] > a[i+1]) h++;

            prev = a[i];
        }
        System.out.println(h);*/
        return count;
    }

}
