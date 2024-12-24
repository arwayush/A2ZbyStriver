package Step3.Easy;

import javax.xml.transform.Source;
import java.util.Arrays;

public class SecondLargestElementWithoutSorting {
//    This is the Brute force approach in which the T.C. is O(n* logn)
   private static void sort(int[] arr, int n){
       Arrays.sort(arr);
       System.out.println(Arrays.toString(arr));
       System.out.println("The 2nd smallest element is: " +arr[1]);
       System.out.println("The 2nd largest is: " +arr[n-2]);
   }
//   Better approach for this is to run two traversals it will take T.C. O(n), also it can handle repetetive elements
    private static void better(int[] arr, int n){
       int mini = Integer.MAX_VALUE;
       int secondSmall = Integer.MAX_VALUE;
       int maxi = Integer.MIN_VALUE;
       int secondMax = Integer.MIN_VALUE;
       //for loop to find the maximum and min values
       for (int num : arr){
           if(num < mini)
               mini = num;
           if(num >  maxi)
               maxi = num;
       }
        for (int i = 0; i < n; i++) {
            if(arr[i] < secondSmall && arr[i] != mini)
                secondSmall = arr[i];
            if(arr[i] > secondMax && arr[i] != maxi)
                secondMax = arr[i];
        }

        System.out.println("Second Smallest: " +secondSmall);
        System.out.println("Second Largest: " +secondMax);
    }

//    Optimal approach for the given problem
    private static void optimal(int[] arr, int n){
       int small = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE, large = Integer.MIN_VALUE, secondLarge = Integer.MIN_VALUE;
        for (int i = 0; i <n; i++) {
            if(arr[i] > large){
                secondLarge = large;
                large = arr[i];
            }else if(arr[i] < large && arr[i] > secondLarge){
                secondLarge = arr[i];
            }
        }
        for (int i = 0; i <n; i++) {
            if(arr[i] < small){
                secondSmall = small;
                small = arr[i];
            }else if(arr[i] < secondSmall && arr[i] != small){
                secondSmall = arr[i];
            }
        }
        System.out.println("The second small is: " +secondSmall);
        System.out.println("The second large is: " +secondLarge);
    }


    public static void main(String[] args) {
        int[] arr = {0,2,4,5,7,2,7,5,4,5,8,81,30};
        int n = arr.length;
        sort(arr, n);
        better(arr, n);
        optimal(arr, n);
    }
}
