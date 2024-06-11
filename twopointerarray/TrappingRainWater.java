package twopointerarray;

import java.util.Arrays;

class TrappingRainWater {

  public int trap(int[] heights) {
    
    int n = heights.length;
    
    int left = 0; 
    int right = n - 1;
    
    int leftMax = 0;
    int rightMax = 0;
    
    int result = 0;
    
    while (left < right) {
        
      if (heights[left] < heights[right]) {
        
        if (heights[left] >= leftMax) {
          // update left max
          leftMax = heights[left];
        } else {
          // water trapped
          result += leftMax - heights[left];
        }
        
        left++;
        
      } else {
        
        if (heights[right] >= rightMax) {
          // update right max
          rightMax = heights[right];
        } else {
          result += rightMax - heights[right];
        }
        
        right--;
      }
    }
    
    return result;
  }

  public static void main(String[] args) {

  TrappingRainWater tr = new TrappingRainWater();

  int[] heights = {3, 0, 2, 0, 4};

  int totalWater = tr.trap(heights);

    System.out.println("Heights: " + Arrays.toString(heights));
    System.out.println("Total water trapped: " + totalWater);

}

}