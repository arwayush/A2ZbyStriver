package Step4.BSOn1DArray;
public class FindOutManyTimesArrayIsRotated {
//    The T.C. of the approach is O(n)
    private static void Brute(int[] arr){
        int n = arr.length, index = -1;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] < mini){
                mini = arr[i];
                index = i;
            }
        }
        System.out.println(index);
    }

    private static void Optimal(int[] arr){
        int n = arr.length;
        int low = 0, high = n-1;
        int index = -1;
        int ans = Integer.MAX_VALUE;
        while (low <=  high){
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]){
                if(arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }else{
                if(arr[mid] < ans){
                    index =  mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        System.out.println(index);
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        Brute(arr);
        Optimal(arr);

    }
}
/*
We need to find the index of minimum element

 */