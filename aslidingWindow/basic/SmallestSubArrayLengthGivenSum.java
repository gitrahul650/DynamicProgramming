package aslidingWindow.basic;

public class SmallestSubArrayLengthGivenSum {

    public static int smallestSubarray(int[] arr, int targetSum) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];
            while (currentSum >= targetSum) {
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= arr[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 7, 8, 1, 2, 8, 1, 0};
        int targetSum = 8;
        int result = smallestSubarray(arr, targetSum);
        System.out.println("Smallest Subarray Length: " + result);
    }
}
