package Step4.BSOn1DArray;

public class FloorAndCeilInSortedArray {
    private static int getFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential overflow
            if (arr[mid] <= x) {
                ans = arr[mid]; // Update floor
                low = mid + 1;  // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return ans;
    }

    private static int getCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential overflow
            if (arr[mid] >= x) {
                ans = arr[mid]; // Update ceil
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int floor = getFloor(arr, n, x);
        int ceil = getCeil(arr, n, x);
        System.out.println("The floor is: "+floor);
        System.out.println("The ceiling is: " +ceil);
    }
}
/*
the floor and ceil of the number X
Condition 1 - if the number X is given, floor and ceil will be 'X' itself
Condition 2 - if the number X is not given, floor will be number just smaller than X and ceil will be the number just bigger than X

floor - largest number in array <= x
ceil - smallest number in the array >= x

 */