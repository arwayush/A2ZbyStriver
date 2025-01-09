package Step4;

public class BS {
    private static int RecursionBs(int[] nums, int low, int high, int target){
        if (low > high) return -1; //Base case.

        // Perform the steps:
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return RecursionBs(nums, mid + 1, high, target);
        return RecursionBs(nums, low, mid - 1, target);
    }
    private static int IterativeBs(int[] nums, int low, int high, int target){
        // Perform the steps:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        System.out.println(RecursionBs(arr, 0, arr.length-1, target));
        System.out.println(IterativeBs(arr, 0, arr.length-1, target));
    }
}
