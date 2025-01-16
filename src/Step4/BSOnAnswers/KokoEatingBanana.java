package Step4.BSOnAnswers;

public class KokoEatingBanana {
    protected static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    protected static int calculateHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
//    Time Complexity: O(max(a[]) * N), and S.C. will be the O(1)
    private static int minimumRateToEatBananas(int[] v, int h){
        int maxi = findMax(v);
        for (int i = 0; i <= maxi; i++) {
            int reqTime = calculateHours(v, i);
            if(reqTime <= h){
                return i;
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas(v, h);
        System.out.println("The koko must eat: " +ans);
    }
}
/*
Return the minimum integer 'k' such that koko can eat all bananas within 'h' hours
The simple linear search in the Brute force can be replaced by the binary search
This approach will gives the TLE while using on the online compiler
 */