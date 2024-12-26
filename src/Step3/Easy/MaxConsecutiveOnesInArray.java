package Step3.Easy;

public class MaxConsecutiveOnesInArray {
//    The simple and the best solution with the T.C. of the O(n)
    private static void count(int[] arr, int n){
        int max_cnt = 0, cnt = 0;
        for (int i = 0; i <n; i++) {
            if(arr[i] == 1){
                cnt++;
            }else{
                cnt = 0;
            }
            max_cnt = Math.max(max_cnt, cnt);
        }
        System.out.println(max_cnt);
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        int n = arr.length;
        count(arr, n);
    }
}
