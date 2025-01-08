package Step3.Hard;
import java.util.*;
public class ReversePairs {
//    this will takes the o(n^2)
    private static void Brute(int[] arr){
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > 2*arr[j]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }


    private static void Optimal(int[] arr){
        int n = arr.length;
        int ans = mergesort(arr, 0, n-1);
        System.out.println(ans);
    }
    protected static void merge(int[] arr, int low, int mid, int high) {
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
    protected static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <=mid; i++) {
            while (right <= high && arr[i] > 2*arr[right])right++;
            cnt += right - (mid + 1);
        }return cnt;
    }
    protected static int mergesort(int[] arr, int low, int high){
        int cnt = 0;
        if(low >= high)  return  cnt;
        int mid = (low + high) / 2;
        cnt += mergesort(arr, low, mid);
        cnt += mergesort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        Brute(arr);
        Optimal(arr);
    }
}
/*
arr[i] > 2 * arr[j]
 */