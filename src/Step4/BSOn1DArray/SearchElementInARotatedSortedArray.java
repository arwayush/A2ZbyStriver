package Step4.BSOn1DArray;

public class SearchElementInARotatedSortedArray {
//    The linear search will take only O(n), and S.C. of O(1)
    private static void Brute(int[] arr, int k){
        int ans = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == k){
                ans = i;
            }
        }
        System.out.println(ans);
    }
//    This will takes the O(log N) and the S.C. of O(1)
    private static int BS(int[] arr, int k){
        int n = arr.length;
        int low = 0, high = n-1;
        while (low <= high){
            int mid = (low + high) / 2;

            //if mid points to target
            if(arr[mid] == k){
                return mid;
            }

            //if left part is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= k && k<=arr[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if(arr[mid] <= k && k<= arr[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        int k = 9;
        Brute(arr, k);
        int ans  = BS(arr, k);
        System.out.println(ans);
    }
}
/*
Now because the Array is rotated and sorted therefore we can use the B.S.
Identify the sorted half i.e. left or right
 */