package a1Dynamic.knapsack01;

public class TargetSum06 {
    //Given an array arr[] of length N and an integer target. You want to build an expression out of arr[]
    // by adding one of the symbols ‘+‘ and ‘–‘ before each integer in arr[] and then
    // concatenate all the integers. Return the number of different expressions that can be built, which evaluates to target.
    //Example: arr[] = {1, 1, 1, 1, 1}, target = 3 -> 5
    //Input : N = 5, arr[] = {1, 1, 1, 1, 1}, target = 3
    //Output: 5
    //Explanation:
    //There are 5 ways to assign symbols to
    //make the sum of array be target 3.
    //
    //-1 + 1 + 1 + 1 + 1 = 3
    //+1 – 1 + 1 + 1 + 1 = 3
    //+1 + 1 – 1 + 1 + 1 = 3
    //+1 + 1 + 1 – 1 + 1 = 3
    //+1 + 1 + 1 + 1 – 1 = 3

    //Approach: Dynamic Programming

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("targetSum(arr, target) = " + targetSum(arr, target));

    }



    public static int targetSum(int[] nums, int target) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;

        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }

}

