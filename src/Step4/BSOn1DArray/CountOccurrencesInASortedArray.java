package Step4.BSOn1DArray;

public class CountOccurrencesInASortedArray {
//    This is the most Brute Force approach which will take the T.C. of O(n)
    private static void Brute(int[] arr, int target){
        int cnt = 0;
        for(int n : arr){
            if(n == target){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

//    This will use the Binary Search which takes the T.C. of O(logN)
    private static void BinarySearch(int[] arr, int target){
        int first = firstOcc(arr, target);
        int last = lastOcc(arr, target);
        int ans = last - first + 1;
        System.out.println("The total number of occurrences are: " +ans);
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
        int[] arr = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int target = 3;
        Brute(arr, target);
        BinarySearch(arr, target);

    }
}
