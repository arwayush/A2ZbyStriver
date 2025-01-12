package Step4.BSOn1DArray;

public class LowerBound {
    private static int lower(int[] arr, int x){
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
        int[] arr = {1,2,2,3,3,5};
        int x = 7;
        int ans = lower(arr, x);
        System.out.println(ans);
    }
}
