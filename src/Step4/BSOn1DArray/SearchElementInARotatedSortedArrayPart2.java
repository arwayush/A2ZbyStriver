package Step4.BSOn1DArray;

public class SearchElementInARotatedSortedArrayPart2 {
//    This will takes the T.C. O(n)., SC of O(1)
    private static Boolean Brute(int[] arr, int k){
        for(int n : arr){
            if(n == k){
                return true;
            }
        }
        return false;
    }
//   The best T.C. is O(log N) and Worst T.C. is O(n/2)
    private static boolean BS(int[] arr, int k){
        int n = arr.length; // size of the array.
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if mid points the target
            if (arr[mid] == k) return true;

            //Edge case:
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (arr[mid] <= k && k <= arr[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        System.out.println(Brute(arr, k));
        System.out.println(BS(arr, k));
    }
}
/*
due to problem of arr[low] == arr[mid] == arr[high]  -> The problem in this approach is
*/