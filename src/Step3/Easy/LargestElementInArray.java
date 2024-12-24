package Step3.Easy;

import java.util.Arrays;

class Approaches{
// 1.   the time complexity of this approach is O(n)
    protected static void Optimized(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > maxi)
                maxi = num;
        }
        System.out.println("The Maximum element is: " +maxi);
    }
    //2. Sorting the array and return the last value,
//    The Time complexity of the algo is O(n*log n)
    protected static void sorted(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        System.out.println(arr[n-1]);
    }


}
public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {2,100,5,64,2,200,5,7,74,3};
        Approaches.Optimized(arr);
        Approaches.sorted(arr);
    }
}
