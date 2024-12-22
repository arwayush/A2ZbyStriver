package Step2.Sorting;

import java.util.Arrays;

public class SelectionSort {
    private static void Selection(int[] arr){
        int n = arr.length;
        for (int i = 0; i <= n-2; i++) { //running the loop from 0 -> n-1
            int mini = i;
            for (int j = i; j <=n-1; j++) {
                if(arr[j] < arr[mini])
                    mini = j;
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {13,45,9,65,32,12};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }
}
/*
Selection sort -> Select the minimms, we will select minimums ans swap

Step1 select minimum
Step2 swap with the first element
Step3 now 1st element is sorted and (n-1) elements are unsorted, we will find the smallest from the n-1 elements and put them to 2nd place in the array
Now the entire array is divided into 2 parts,  1 -> sorted & 2 -> unsorted
We will always find the smallest and put to next to the sorted
-> Like this it will take n-1 steps to sort all the elements

0-n check krna hai -> swap number with 0
1-n check krna hai -> swap with 1
2-n check krna hai -> swap with 2


The Time complexity of the selection sort is :- T.C. O(n^2)
 */