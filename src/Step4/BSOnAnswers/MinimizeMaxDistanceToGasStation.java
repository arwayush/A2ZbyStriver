package Step4.BSOnAnswers;

import java.util.ArrayList;
import java.util.Collections;

public class MinimizeMaxDistanceToGasStation {
//    The T.C. of this Brute force approach will be nearly O(n*k)
    private static double Brute(int[] arr, int k) {
        int n = arr.length;
        // Initialize the number of additional gas stations between each pair to 0
        ArrayList<Integer> howMany = new ArrayList<>(Collections.nCopies(n - 1, 0));

        // Add k gas stations
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            double maxSelection = -1;
            int maxInd = -1;

            // Find the segment with the maximum distance per partition
            for (int i = 0; i < n - 1; i++) { // Fix the loop range
                double diff = arr[i + 1] - arr[i];
                double selectionLength = diff / (double) (howMany.get(i) + 1);
                if (selectionLength > maxSelection) {
                    maxSelection = selectionLength;
                    maxInd = i;
                }
            }

            // Add a gas station to the segment with the maximum selection length
            howMany.set(maxInd, howMany.get(maxInd) + 1);
        }

        // Calculate the maximum distance after adding all gas stations
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) { // Fix the loop range
            double diff = arr[i + 1] - arr[i];
            double selectionLength = diff / (double) (howMany.get(i) + 1);
            maxAns = Math.max(maxAns, selectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        double ans = Brute(arr, k);
        System.out.println("The minimized maximum distance is: " + ans);
    }
}
