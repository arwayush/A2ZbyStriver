package Step4.BSOnAnswers;

public class KokoEatingBananasBS {
//    Side functions to calculate the maximum value in the array
    protected static int findMax(int[] v){
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return  maxi;
    }
    protected static int calculateTotalHours(int[] v, int mid){
        int totalH = 0;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (v[i]) / (double) (mid));
        }
        return totalH;
    }
    private static int minimumRateToEatBananas(int[] v, int h){
        int low = 1, high = findMax(v);
        while (low <=  high){
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(v, mid);
            if(totalH <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minimumRateToEatBananas(v, h);
        System.out.println(ans);
    }
}
