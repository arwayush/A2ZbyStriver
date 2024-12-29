package Step3.Medium;

public class StockBuyAndSell {
//    This is the Code with the T.c. of the O(n^2), S.C. O(1),
//    This code will give the TLE in the leetcode
    protected static void Brute(int[] arr){
        int n=arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]){
                    maxi = Math.max(arr[j]-arr[i], maxi);
                }
            }
        }
        System.out.println(maxi);
    }
//    We just finding the max-min while running a single loop, The T.C. of this will be O(n) and S.C. of O(1)
    protected static void Optimal(int[] arr){
        int n = arr.length;
        int maxo = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxo = Math.max(maxo, arr[i] - minPrice);
        }
        System.out.println(maxo);
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        Brute(arr);
        Optimal(arr);
    }
}
