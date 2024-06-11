package aslidingWindow.basic;

public class MaxConsecutiveOnes {
    //Given binary array, find count of maximum number of consecutive 1’s
    // present in the array.
    //Given a binary array nums and an integer k,
    // return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = maxConsecutiveOnes(arr, k);
        System.out.println("Max Consecutive Ones: " + result);
    }

    public static int maxConsecutiveOnes(int[] arr, int k) {
        int maxCount = 0;
        int zeroCount = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (arr[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }
        return maxCount;
    }


}
