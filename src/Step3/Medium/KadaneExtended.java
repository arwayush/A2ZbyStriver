package Step3.Medium;

public class KadaneExtended {
    protected static void KadaneExtend(int[] arr){
        int maxi = Integer.MIN_VALUE;
        int n =arr.length;
        int sum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {
            if(sum == 0) start = i;

            sum += arr[i];

            if(sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if(sum < 0)
                sum = 0;
        }

        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");

        System.out.println(maxi);
    }
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        KadaneExtend(arr);
    }
}
/*
  There might be more than one subarray with the max sum, we need to print any of them
  Intuition :- our approach is to store the starting index and ending index of subarray, so we can easily get the subarray afterward without actually storing subarray elements

 */