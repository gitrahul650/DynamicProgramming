package twopointerarray;

import java.util.Arrays;

class ContainerWithMostWater {

  public int maxArea(int[] heights) {
    int maxArea = 0;
    int left = 0;
    int right = heights.length - 1;
    
    while (left < right) {
      int width = right - left;
      int height = Math.min(heights[left], heights[right]);
      int area = width * height;
      maxArea = Math.max(maxArea, area);
      
      if (heights[left] < heights[right]) {
        left++;  
      } else {
        right--;
      }
    }
    
    return maxArea;
  }

  public static void main(String[] args) {
    ContainerWithMostWater c = new ContainerWithMostWater();
    int[] heights = {1,8,6,2,5,4,8,3,7};

    int maxArea = c.maxArea(heights);

    System.out.println("Heights: " + Arrays.toString(heights));
    System.out.println("Max Area: " + maxArea);
  }
}
