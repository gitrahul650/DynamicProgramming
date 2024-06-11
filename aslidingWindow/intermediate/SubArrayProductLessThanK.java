package aslidingWindow.intermediate;

public class SubArrayProductLessThanK {
    //Number of subarrays having product less than K
    //Given an array of positive integers nums and a positive integer k,
    // return the number of contiguous subarrays whose product is less than k.

    public static void main(String[] args) {
//        int[] arr = {10, 5, 2, 6};
//        int k = 100;
        int[] arr = {1, 2, 3, 4};
        int k = 10;
        int result = numSubarrayProductLessThanK(arr, k);
        System.out.println("Number of subarrays having product less than K: " + result);
    }

public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int count = 0;
        int product = 1;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            product *= arr[end];
            while (product >= k) {
                product /= arr[start];
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }





}
