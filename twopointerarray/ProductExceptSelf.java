package twopointerarray;

import java.util.Arrays;

class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {

    int n = nums.length;
    int[] output = new int[n];

    output[0] = 1;
    for (int i = 1; i < n; i++) {
      output[i] = output[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
      output[i] *= right;
      right *= nums[i];
    }

    return output;
  }

  public static void main(String[] args) {

    ProductExceptSelf product = new ProductExceptSelf();

    int[] nums = {1, 2, 3, 4};
    int[] out = product.productExceptSelf(nums);

    System.out.println(Arrays.toString(out));
  }
}