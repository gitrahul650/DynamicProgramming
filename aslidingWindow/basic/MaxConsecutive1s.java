package aslidingWindow.basic;

public class MaxConsecutive1s {
    // Maximum consecutive one’s (or zeros) in a binary array

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
        int result = maxConsecutiveOnes2(arr);
        System.out.println("Max Consecutive Ones: " + result);
    }

    public static int maxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                start = end + 1;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }
        return maxCount;
    }

    //please try to solve it by iterating the array only once
    public static int maxConsecutiveOnes2(int[] arr) {
        int maxCount = 0;
        int currentCount = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        return Math.max(maxCount, currentCount);
    }


}
