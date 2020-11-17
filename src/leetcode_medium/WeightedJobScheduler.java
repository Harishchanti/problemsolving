package leetcode_medium;

// https://www.geeksforgeeks.org/weighted-job-scheduling/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedJobScheduler {
    public static void main(String[] args) {
        //         Job arr[]={{3,10,20},{1,2,50},{6,19,100},{2,100,200}};
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job(3, 10, 20));
        jobList.add(new Job(1, 2, 50));
        jobList.add(new Job(6, 19, 100));
        jobList.add(new Job(2, 100, 20));

        System.out.print(maxProfit(jobList));
    }

    private static int maxProfit(List<Job> jobList) {

        Collections.sort(jobList);

        for (Job j : jobList) {
            System.out.println(j);
        }


        return findMaxProfitR(jobList, jobList.size());
    }

    private static int findMaxProfitR(List<Job> jobList, int n) {

        if (n == 1) {
            return jobList.get(n - 1).profit;
        }

        int inclProf = jobList.get(n - 1).profit;
        int i = latestNonConflict(jobList, n);
        if (i != -1)
            inclProf += findMaxProfitR(jobList, i + 1);

        // Find profit when current job is excluded
        int exclProf = findMaxProfitR(jobList, n - 1);

        return Math.max(inclProf, exclProf);

    }

    private static int latestNonConflict(List<Job> jobList, int n) {
        for (int j = n - 1; j >= 0; j--) {
            if (jobList.get(j).end <= jobList.get(n - 1).start)
                return j;
        }
        return -1;
    }
}

class Job implements Comparable {
    int start, end, profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "start=" + start +
                ", end=" + end +
                ", profit=" + profit +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Job o1 = (Job) o;
        return o1.end - this.end;
    }
}
/*

        bool jobComparataor(Job s1,Job s2)
        {
        return(s1.finish<s2.finish);
        }

// Find the latest job (in sorted array) that doesn't
// conflict with the job[i]. If there is no compatible job,
// then it returns -1.
        int latestNonConflict(Job arr[],int i)
        {
        for(int j=i-1;j>=0;j--)
        {
        if(arr[j].finish<=arr[i-1].start)
        return j;
        }
        return-1;
        }

// A recursive function that returns the maximum possible
// profit from given array of jobs.  The array of jobs must
// be sorted according to finish time.
        int findMaxProfitRec(Job arr[],int n)
        {
        // Base case
        if(n==1)return arr[n-1].profit;

        // Find profit when current job is inclueded
        int inclProf=arr[n-1].profit;
        int i=latestNonConflict(arr,n);
        if(i!=-1)
        inclProf+=findMaxProfitRec(arr,i+1);

        // Find profit when current job is excluded
        int exclProf=findMaxProfitRec(arr,n-1);

        return max(inclProf,exclProf);
        }

// The main function that returns the maximum possible
// profit from given array of jobs
        int findMaxProfit(Job arr[],int n)
        {
        // Sort jobs according to finish time
        sort(arr,arr+n,jobComparataor);

        return findMaxProfitRec(arr,n);
        }

// Driver program
        int main()
        {
        Job arr[]={{3,10,20},{1,2,50},{6,19,100},{2,100,200}};
        int n=sizeof(arr)/sizeof(arr[0]);
        cout<<"The optimal profit is "<<findMaxProfit(arr,n);
        return 0;
        }*/