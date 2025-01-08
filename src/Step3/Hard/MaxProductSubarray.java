package Step3.Hard;

public class MaxProductSubarray {
    private static void Brute(int[] arr){
        int maxProduct = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int product = arr[i];
            for (int j = i+1; j < n; j++) {
                maxProduct = Math.max(product, maxProduct);
                product *= arr[j];
            }
            maxProduct = Math.max(maxProduct, product);
        }
        System.out.println(maxProduct);
    }

    private static void Optimal(int[] arr){
        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[i];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        System.out.println(ans);
    }

    private static void MostOptimal(int[] arr){
        int prod1 = arr[0],prod2 = arr[0],result = arr[0];

        for(int i=1;i<arr.length;i++) {
            int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,-3, 0, -4, -5};
        Brute(arr);
        Optimal(arr);
        MostOptimal(arr);
    }
}

/*
In the optimal approach we will see
1. All +ve -> whole product will be max
2. Even -ve -> prefix and suffix with the even -ve will be max
3. Odd -ve -> need to check
4. It has zeroes -> we will check all the subarray which does not contains the 0s and find the max of them
whenever we'll see 0 turn it back to 1
 */
