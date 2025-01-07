package Step3.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeTwoSortedArraysWithoutSpace {
    private static void Brute(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        long[] arr3 = new long[n+m];
        int left = 0, right = 0, index = 0;
        while (left < n && right < m){
            if(arr1[left] <= arr2[right]){
                arr3[index] = arr1[left];
                left++;
                index++;
            }else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }
        //if right pointer reaches end
        while (left < n){
            arr3[index++] = arr1[left++];
        }
        //if left pointer reaches end
        while (right < m){
            arr3[index++] = arr2[right++];
        }
        System.out.println(Arrays.toString(arr3));
    }

    private static void Optimal1(int[] arr1, int[] arr2){
       //swapping the elements untill arr1[left] is smaller than arr2[right]
        int n = arr1.length;
        int m = arr2.length;
        int left = n-1;
        int right = 0;
        while (left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void main(String[] args) {
        int arr1[] = {1, 4, 8, 10};
        int arr2[] = {2,3,9};
        Brute(arr1, arr2);
        Optimal1(arr1, arr2);
    }
}
