package Step3.Hard;

import java.util.*;
import java.util.Set;

public class FourSum {
//    The Time Complexity of this approach will be O(n^4), S.C. O(2 * no. of the quadruplets)
    private static void Brute(int[] nums, int target){
        int n = nums.length; // size of the array
        Set<List<Integer>> set = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // taking bigger data type
                        // to avoid integer overflow:
                        long sum = (long)nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        System.out.println(ans);
    }
//   The Time Complexity of this approach will be O(N3*log(M)), S.C.  O(2 * no. of the quadruplets)+O(N)
    private static void Better(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j < n; j++) {
                Set<Integer> hst = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target - (nums[i] + nums[j] + nums[k]);
                    if (hst.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    hst.add(nums[k]);
                }
            }
        }
        System.out.println(st);
    }

    private static void Optimal(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            //we will check for the same elements
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while (k < l){
                    int sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++; l--;
                        while (k<l && nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;
                    } else if (sum <  target) {
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;
        Brute(arr, target);
        Better(arr, target);
        Optimal(arr, target);
    }
}
/*
Sum of the 4 numbers add to give the 0
 */