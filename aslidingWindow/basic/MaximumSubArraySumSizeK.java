package aslidingWindow.basic;

public class MaximumSubArraySumSizeK {

    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[i - (k - 1)];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum Sum: " + result);
    }

    }
