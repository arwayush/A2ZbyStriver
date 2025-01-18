package Step4.BSOnAnswers;

public class CapacityToShipPackages {
    private static int func(int weights[], int cap){
        int days = 1, load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if(load + weights[i] > cap){
                days+=1;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    private static int Brute(int[] weights, int days){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : weights){
            maxi = Math.max(maxi, i);
            sum += i;
        }
        for (int i = maxi; i <=sum; i++) {
            int daysReq = func(weights, i);
            if(daysReq <= days)
                return i;
        }
        return  -1;
    }

//    T.C. of O(log(sum-max + 1)) and S.C O(1)
    private static int BS(int[] weights, int days){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : weights){
            maxi = Math.max(maxi, i);
            sum += i;
        }
        int low = maxi, high = sum;
        while (low <= high){
            int mid = (low + high) / 2;
            int daysReq = func(weights, mid);
            if(daysReq <= days){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int weights[] = {5,4,5,2,3,4,5,6};
        int days = 5;
        int ans = Brute(weights, days);
        System.out.println(ans);
        int ans2 = BS(weights, days);
        System.out.println(ans2);
    }
}
