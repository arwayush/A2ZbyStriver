package Step4.BSOn1DArray;

public class SearchInsertPosition {
    private static int test(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1, ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,7};
        int x = 6;
        int ans = test(arr, x);
        System.out.println(ans);
    }
}
/*
-> Check if is it already present in the array, if yes then return its index
-> if not  present, then you need to give the index where it can be inserted.

 */
