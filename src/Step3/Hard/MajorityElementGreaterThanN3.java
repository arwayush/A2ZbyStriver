package Step3.Hard;

import java.util.*;

public class MajorityElementGreaterThanN3 {
//    This process will take O(n^2), and will only give us the count of element greater than n/3
    protected static void Brute(int[] arr, int n){
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            // Count occurrences of arr[i]
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                }
            }

            // Check if arr[i] is a majority element
            if (cnt > (n / 3) && !ans.contains(arr[i])) { // Avoid duplicates
                ans.add(arr[i]);
            }

            // Since there can be at most 2 elements > n/3, break early
            if (ans.size() == 2) break;
        }

        System.out.println(ans);
    }
//    This process is lit better and takes only O(n* logn), and a S.C. of O(n)
    protected static void Better(int[] arr, int n){
       HashMap<Integer,Integer> mp = new HashMap<>();
       List<Integer> ls = new ArrayList<>();
       int mini = (int)(n/3) + 1; //if the element comes n/3 times, then in the single iteration we will keep the track of the elemetns which can comes n/3 times and put them in the list

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) +1);
            if(mp.get(arr[i]) == mini){
                ls.add(arr[i]);
            }
            if(ls.size() == 2) break;
        }
        System.out.println(ls);
    }

    protected static void BoyerMooreVotingAlgo(int[] arr, int n){
        int cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(cnt1 == 0 && el2 != arr[i]){
                cnt1 = 1;
                el1 = arr[i];
            }else if (cnt2 == 0 && el1 != arr[i]){
                cnt2 = 1;
                el2 = arr[i];
            }else if(arr[i] == el1) cnt1++;
            else if(arr[i] == el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if(el1 == arr[i]) cnt1++;
            if(el2 == arr[i]) cnt2++;
        }
        int mini = (int)(n/3)+1;
        if(cnt1 >= mini) ans.add(el1);
        if(cnt2 >=  mini) ans.add(el2);
        Collections.sort(ans);
        System.out.println(ans);


    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,1,2,2,2};
        int n = arr.length;
        Brute(arr, n);
        Better(arr, n);
        BoyerMooreVotingAlgo(arr, n);
    }
}
