package Step4.BSOn1DArray;

public class FirstAndLastOccurenceOfAGivenNumberInSortedArray {
//    Takes the T.C. of O(n)
    private static void TwoPointer(int[] arr, int target){
        int n = arr.length;
        int lowAns = -1;
        int highAns = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == target){
                if(lowAns == -1) {
                    lowAns = i;
                }
                highAns = i;
            }

        }
        System.out.println(lowAns);
        System.out.println(highAns);

    }

//    The B.S. takes the O(log N)
    private static void BinarySearch(int[] arr, int target){
        int first = firstOcc(arr, target);
        int last = lastOcc(arr, target);
        System.out.println("1st occurrence: " +first);
        System.out.println("2nd Occurrence: " +last);
    }
    protected static int firstOcc(int[] arr, int target){
        int low = 0, high = arr.length-1, ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return ans;
    }
    protected static int lastOcc(int[] arr, int target){
        int low = 0, high = arr.length-1, ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {5,7,7,8,8,10};
        int target = 8;
        TwoPointer(arr, target);
        BinarySearch(arr, target);
    }
}
