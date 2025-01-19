package Step4.BSOnAnswers;

public class PaintersPartition {
    public static int func(int[] arr, int pages){
        int n = arr.length;
        int student = 1, pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if(pagesStudent + arr[i] <= pages){
                pagesStudent += arr[i];
            }else {
                student++;
                pagesStudent = arr[i];
            }
        }
        return student;
    }

    private static int BS(int[] arr, int m){
        int n =arr.length;
        if(m > n) return -1; //edge case
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : arr){
            maxi = Math.max(maxi,i);
            sum += i;
        }
        int low = maxi, high = sum;
        while (low <= high){
            int mid = (low + high) / 2;
            int stud = func(arr, mid);
            if(stud > m){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] painters = {10, 20, 30, 40};
        int k = 2;
        int ans = BS(painters, k);
        System.out.println(ans);

    }
}
/*
min(max)
each painter will get at least one job to do
task needs to be consecutive
We need to split the given array into the 'k' sub-arrays and find the max of those sub-arrays
from all the max values we will find the minimum value
 */