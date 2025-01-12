package Step4.BSOn1DArray;

import java.util.HashMap;
import java.util.Map;

public class SearchSingleElementInSortedArray {
//    Takes the O(n) for the traversal
    private static void Brute(int[] arr) {
        int n = arr.length;
        int ans = -1; // Initialize with -1 to signify "not found"

        // Edge case: Single element array
        if (n == 1) {
            ans = arr[0];
        } else {
            // Check each element for uniqueness
            for (int i = 0; i < n; i++) {
                if (i == 0) { // Check the first element
                    if (arr[i] != arr[i + 1]) {
                        ans = arr[i];
                        break;
                    }
                } else if (i == n - 1) { // Check the last element
                    if (arr[i] != arr[i - 1]) {
                        ans = arr[i];
                        break;
                    }
                } else { // Check the middle elements
                    if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                        ans = arr[i];
                        break;
                    }
                }
            }
        }

        // Output the result
        System.out.println(ans);
    }
//    Takes the O(n) for the traversal, S.C. of O(1)
    private static void Hashing(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        // Iterating over the hashmap and finding the single occurrence of the number
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }

    }
//    Takes the O(n) for the traversal, S.C. of O(1)
    private static void Xor(int[] arr){
        int ans = 0;
        for(int n : arr){
            ans ^= n;
        }
        System.out.println(ans);
    }
//    Takes the O(log n) for the traversal, S.C. of O(1)
    private static int BS(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            // If the pair is valid, move to the right half
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                // Otherwise, move to the left half
                high = mid;
            }
        }

        // The single element is at the remaining index
        return nums[low];
}

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7};
        Brute(arr);
        Hashing(arr);
        Xor(arr);
        int ans = BS(arr);
        System.out.println(ans);
    }
}
