package Step3.Hard;

public class SubarrayWithGivenXORNumber {
//    The T.C. of this approach is the O(n^3), and S.C. of this is O(1)
    private static void Brute(int[] arr, int target){
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //calculate the xor of all elements
                int xorr = 0;
                for (int k = i; k <=j; k++) {
                    xorr ^= arr[k];
                }
                if(xorr == target) cnt++;
            }
        }
        System.out.println(cnt);
    }
//    The T.C. of this approach is the O(n^2), and S.C. of this is O(1)
    protected static void Better(int[] arr, int target) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int xorr = 0;
            for (int j = i; j < n; j++) {
                xorr ^= arr[j];
                if(xorr == target) cnt++;
            }
        }
        System.out.println(cnt);
    }
//    The T.C. of this approach is the O(n^3), and S.C. of this is O(1)
    protected static void Optimal(int[] arr, int target){
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        Brute(arr, k);
        Better(arr, k);
        Optimal(arr, k);
    }
}
