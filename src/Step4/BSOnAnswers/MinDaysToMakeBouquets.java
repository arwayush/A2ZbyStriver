package Step4.BSOnAnswers;

public class MinDaysToMakeBouquets {
//   The T.C. of the algo is O((max(arr[])-min(arr[])+1) * N)
    public class Brute{
        private static boolean possible(int[] arr, int day, int m, int k){
            int n = arr.length;
            int cnt = 0;
            int noOfBouquets = 0;
            // we need to find the k adjacent flowers bloomed
            for (int i = 0; i < n; i++) {
                if(arr[i] <= day){
                    cnt++;
                }else {
                    noOfBouquets += (cnt / k);
                    cnt = 0;
                }
            }
            noOfBouquets += (cnt / k);
            return noOfBouquets >= m;
        }
        public static int roseGarden(int[] arr, int k, int m){
            long val = (long) m * k;
            int n = arr.length;
            if(val > n) return -1; //edge case
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for(int i : arr){
                mini = Math.min(mini, i);
                maxi = Math.max(maxi, i);
            }

            //now running a loop from the mini to maxi and find minimum possible answer
            for (int i = mini; i <= maxi; i++) {
                if(possible(arr, i, m, k))
                    return i;
            }
            return -1;
        }
    }
//   The T.C. of the optimal approach is O(log(max(arr[])-min(arr[])+1) * N)
    public class Optimal{
        private static boolean possible(int[] arr, int day, int m, int k){
            int n = arr.length;
            int cnt = 0;
            int noOfBouquets = 0;
            // we need to find the k adjacent flowers bloomed
            for (int i = 0; i < n; i++) {
                if(arr[i] <= day){
                    cnt++;
                }else {
                    noOfBouquets += (cnt / k);
                    cnt = 0;
                }
            }
            noOfBouquets += (cnt / k);
            return noOfBouquets >= m;
        }
        public static int roseGarden(int[] arr, int m, int k){
            long val = (long) m * k;
            int n = arr.length;
            if(val > n) return -1; //edge case
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for(int i : arr){
                mini = Math.min(mini, i);
                maxi = Math.max(maxi, i);
            }
            int ans = 0;
            while (mini <= maxi){
                int mid = (mini + maxi) / 2;
                if(possible(arr, mid, m, k)){
                    ans = mid;
                    maxi = mid - 1;
                }else {
                    mini = mid + 1;
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        int [] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int bouquets = 2;
        int flowers = 3;
        int ans = Brute.roseGarden(arr, flowers, bouquets);
        System.out.println("The answer from the Brute force is the: " +ans);
        int ans2 = Optimal.roseGarden(arr, flowers, bouquets);
        System.out.println("The answer from the Optimal approach is the: " +ans2);

    }
}
