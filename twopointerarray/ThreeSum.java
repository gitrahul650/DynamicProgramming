package twopointerarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums, int target) {
    Arrays.sort(nums);
    
    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) { 
        int j = i + 1, k = nums.length - 1;
        while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == target) {
            triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
            j++; k--;
            while (j < k && nums[j] == nums[j - 1]) j++; 
          } else if (sum < target) {
            j++;
          } else {
            k--;
          }
        }
      }
    }
    return triplets;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    int target = 0;

    ThreeSum ts = new ThreeSum();
    List<List<Integer>> triplets = ts.threeSum(nums, target);

    System.out.println(triplets);
  }
}