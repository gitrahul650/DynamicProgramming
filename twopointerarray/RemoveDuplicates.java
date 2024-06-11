package twopointerarray;

class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }


  public static void main(String[] args) {

    int[] nums = {1, 1, 2, 3, 3, 4, 5};

    RemoveDuplicates rd = new RemoveDuplicates();
    int k = rd.removeDuplicates(nums);

    System.out.println("Array after removing duplicates: ");
    for(int i=0; i<k; i++) {
      System.out.print(nums[i] + " ");
    }
  }
}