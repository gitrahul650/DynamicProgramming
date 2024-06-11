package twopointerarray;

class MinSizeSubarraySum {

  public int minSubArrayLen(int target, int[] nums) {
    
    int n = nums.length;
    int left = 0;
    int sum = 0; 
    int minLen = Integer.MAX_VALUE;
    
    for(int i = 0; i < n; i++) {
      sum += nums[i];
      
      while(sum >= target) {
        minLen = Math.min(minLen, i - left + 1);  
        sum -= nums[left++]; 
      }
    }   
    return (minLen != Integer.MAX_VALUE) ? minLen : 0; 
  }

  public static void main(String[] args) {

    MinSizeSubarraySum minSize = new MinSizeSubarraySum();

    int[] nums = {2, 3, 1, 2, 4, 3};
    int target = 7;

    int minLen = minSize.minSubArrayLen(target, nums);

    System.out.println("Minimum length: " + minLen);
  }
}