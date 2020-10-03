package dp;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/7338929/find-all-ways-to-sum-given-number-with-repetitions-allowed-from-given-set
public class CountPossiblewayGetSumation {
    public static void main(String[] args) {

        int a[] = {1,2};
        int k = 8;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        populateSubsetSum(a,k,0,0,ans,new ArrayList<>());//array,sum,initial_sum,global 2d list,temp list
        for(List<Integer> s:ans) {
            s.forEach(r->System.out.print(r +" "));
            System.out.println();
        }
    }
    static void populateSubsetSum(int[]a, int K, int runSum, int idx, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> al){
        if(idx>=a.length || runSum>K)
            return;
        if(runSum==K){
            ans.add(new ArrayList<>(al));
            return;
        }
        ArrayList<Integer> temp=new ArrayList<>(al);
        temp.add(a[idx]);
        populateSubsetSum(a,K,runSum+a[idx],idx,ans,temp);//when repitions of elements are allowed
        populateSubsetSum(a,K,runSum,idx+1,ans,al);
    }
}
