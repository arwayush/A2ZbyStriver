package Step2.Sorting;
import java.util.*;
public class MergeSort {
    //merging back the elements to make a big array
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    //for the division of array to single element
    public static void merging(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        merging(arr, low, mid);  // left half
        merging(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }

    //main function
    public static void main(String args[]) {
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: " +Arrays.toString(arr));
        merging(arr, 0, n - 1);
        System.out.println("After sorting array: " +Arrays.toString(arr));
    }

}
/*
merge sort -> In this we will divide and merge

Divide -> the array in 2 parts hypothetically,
Take the left part and again divide it in 2 parts, repeat the steps again and divide until all the numbers
divide up to single number


Merge -> The 2 arrays with the single element, and in the ascending order

 */