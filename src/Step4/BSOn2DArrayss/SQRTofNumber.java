package Step4.BSOn2DArrayss;

public class SQRTofNumber {
//    This approach takes the O(n/2)
    private static void Brute(int n){
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(i*i <= n){
                ans = i;
            }else {
                break;
            }
        }
        Math.floor(ans);
        System.out.println(ans);
    }
//    This built-in function will take the T.C. O(log n)
    private static void SqrtFunc(int n){
    int ans = (int) Math.sqrt(n);
    System.out.println(ans);
    }
//    The Binary Search function will work and takes only O(log N)
    private static void BS(int n){
        int low = 1, high = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid * mid < n){
                low = mid+1;
            }else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

    public static void main(String[] args) {
        int n = 28;
        Brute(n);
        SqrtFunc(n);
        BS(n);
    }
}
/*
-> n = 36, so the sqrt of the number will be 6
-> n = 28, so the sqrt of number will be the floor of 5.292 i.e. 5
 */