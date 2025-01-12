package Step4.BSOn1DArray;

public class UpperBound {
    private static int upper(int[] arr, int x){
        int n = arr.length;
        int low = 0, high = n-1, ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 10};
        int x = 10;
        int ans = upper(arr, x);
        System.out.println(ans);
    }
}
