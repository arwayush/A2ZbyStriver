package Step4.BSOnAnswers;

public class KthElementOf2SortedArrays {
//    Time Complexity O(n+m) & S.C. O(1)
    private static int UsingLinear(int[] arr1, int[] arr2, int k){
        int i = 0, j = 0;
        int  n = arr1.length, m = arr2.length;
        int count = 0;
        int ele = -1;
        while (i < n && j < m){
            if(arr1[i] < arr2[j]){
                if(count == k-1) ele = arr1[i];
                count++;
                i++;
            }else {
                if(count == k-1) ele = arr2[j];
                count++;
                j++;
            }
        }
        //copying the left out elements
        while (i < m){
            if(count == k-1) ele = arr1[i];
            count++;
            i++;
        }
        while (j < n){
            if (count == k-1) ele = arr2[j];
            count++;
            j++;
        }
       return ele;
    }
    public static void main(String[] args) {
        int[] arr1  ={2,3,6,7,9};
        int[] arr2 = {1,4,8,10};
        int k = 4;
        int ans = UsingLinear(arr1, arr2, k);
        System.out.println(ans);


    }
}
