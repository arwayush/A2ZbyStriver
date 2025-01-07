package Step3.Hard;

import java.util.*;

public class CountInversionsInAnArray {
//    T.C. is O(n^2), S.C. is O(1)
    private static void Brute(int[] arr){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // To store pairs
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // Create a new ArrayList to store the pair
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    ans.add(temp); // Add the pair to the result list
                }
            }
        }

        // Print the pairs
        System.out.println("Pairs where arr[i] > arr[j]:");
        System.out.println(ans);
    }
//   T.C. O(n*LogN)
private static int merge(int[] arr, int low, int mid, int high) {
    ArrayList<Integer> temp = new ArrayList<>(); // temporary array
    int left = low;      // starting index of left half of arr
    int right = mid + 1;   // starting index of right half of arr

    //Modification 1: cnt variable to count the pairs:
    int cnt = 0;

    //storing elements in the temporary array in a sorted manner//

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp.add(arr[left]);
            left++;
        } else {
            temp.add(arr[right]);
            cnt += (mid - left + 1); //Modification 2
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
    return cnt; // Modification 3
}

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }



    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        Brute(arr);
        int n = arr.length;
        int ans = mergeSort(arr, 0, n-1);
        System.out.println(ans);
    }
}
/*
if (i < j) and arr[i] > arr[j]
 -> left element must be greater than the right element
 ->
 */