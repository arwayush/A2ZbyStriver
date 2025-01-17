package Step4.BSOnAnswers;

public class SmallestDivisorGivenAThreshold {
    private static int Brute(int [] arr, int limit){
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i : arr){
            maxi = Math.max(maxi, i);
        }
       //finding the smallest divisor
        for (int i = 1; i <= maxi; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.ceil((double) (arr[j]) / (double)(i));
            }
            if (sum <= limit)
                return i;
        }
        return -1;
    }
//   The T.C. of this code is  O(log(max(arr[]))*N)
    private static int BS(int[] arr, int limit){
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i : arr){
            maxi = Math.max(maxi, i);
        }
        int low = 1, high = maxi;
        //applying BS
        while (low <= high){
            int mid = (low + high) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) (arr[i]) / (double)(mid));
            }
            if(sum <= limit){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return  low;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = Brute(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
        int ans2 = BS(arr, limit);
        System.out.println("The answer from the BS is:  "  +ans2);
    }
}
