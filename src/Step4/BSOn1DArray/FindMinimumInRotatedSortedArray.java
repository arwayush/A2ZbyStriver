package Step4.BSOn1DArray;

public class FindMinimumInRotatedSortedArray {
//    Takes the T.C. of the O(n) and S.C. of O(1)
    private static void Solution1(int[] arr){
        int mini = Integer.MAX_VALUE;
        for(int i : arr){
            if(i < mini){
                mini = i;
            }
        }
        System.out.println(mini);
    }
//    Takes the T.C. of the O(logN) and S.C. of the O(1)
    private static void Solution2(int[] arr){
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(arr[low] <=  arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }else if(arr[mid] <=  arr[high]){
                ans = Math.min(ans,arr[mid]);
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static void Solution3(int[] arr){
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(arr[low] <=  arr[high]){
                //if the search space is already sorted, then always arr[low] will be smaller in the search space
                ans = Math.min(ans, arr[low]);
                break;
            }

            if(arr[low] <=  arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }else{
                high = mid - 1;
                ans = Math.min(ans,arr[mid]);
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,-1,2,3};
        Solution1(arr);
        Solution2(arr);
        Solution3(arr);
    }
}

/*
Eliminate either the left half or the right half
-> Identify the sorted half
-> But the sorted half may or may not have the answer
-> pick the minimum from the sorted half & eliminate

 */
