package Step4.BSOnAnswers;

public class SplitArray {
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
        int[] arr = {7,2,5,10,8};
        int k = 2;
        int ans = BS(arr, k);
        System.out.println(ans);

    }
}
/*
Split the array into the k contigous sub-arrays, and each of the array must have at least 1 sub-array
find the min(max)

 */
