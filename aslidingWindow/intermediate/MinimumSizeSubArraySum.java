package aslidingWindow.intermediate;

public class MinimumSizeSubArraySum {
    //Minimum Size Subarray Sum
    //Given an array of positive integers nums and a positive integer target,
    // return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(target, arr);
        System.out.println("Minimum Size Subarray Sum: " + result);
    }

    public static int minSubArrayLen(int target, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
