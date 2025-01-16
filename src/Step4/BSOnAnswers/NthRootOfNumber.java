package Step4.BSOnAnswers;

public class NthRootOfNumber {
    public static long fun(int b, int exp){
        long ans = 1;
        long base = b;
        while (exp > 0){
            if(exp % 2 == 1){
                exp--;
                ans = ans * base;
            }else {
                exp /= 2;
                base = base * base;
            }
        }
        return ans;

    }
    public static int func(int mid, int n, int m){
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if(ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

//    This will take the T.C. of the O(M)
    private static int Linear(int n, int m){
        for (int i = 1; i <= m; i++) {
          long val = fun(i,n);
          if(val == (long)m) return i;
          else if(val > (long) m) break;
        }
        return -1;
    }
//    The Binary Search algo takes the T.C. of O(logN)
    private static int BS(int n, int m){
        int low = 1, high = m;
        while(low <=  high){
            int mid = (low + high)/2;
            int midN = func(mid, n, m);
            if(midN == 1){
                return mid;
            }else if(midN == 0){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3, root = 27;
        int ans = Linear(n, root);
        System.out.println(ans);
        int ans2 = BS(n, root);
        System.out.println(ans2);

    }
}
