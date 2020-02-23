class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
      if (k == 0) return new double[0];
      double[] ans = new double[nums.length - k + 1];
      int[] window = new int[k];
      for (int i = 0; i < k; ++i)
        window[i] = nums[i];
      Arrays.sort(window);
      for (int i = k; i <= nums.length; ++i) {
        ans[i - k] = ((double)window[k / 2] + window[(k - 1)/2]) / 2;
        if (i == nums.length) break;
        remove(window, nums[i - k]);
        insert(window, nums[i]);
      }
      return ans;
    }
   
    // Insert val into window, window[k - 1] is empty before inseration
    private void insert(int[] window, int val) {
      int i = Arrays.binarySearch(window, val);
      if (i < 0) i = - i - 1;   
      int j = window.length - 1;
      while (j > i) window[j] = window[--j];
      window[j] = val;
    }
   
    // Remove val from window and shrink it.
    private void remove(int[] window, int val) {
      int i = Arrays.binarySearch(window, val);
      while (i < window.length - 1) window[i] = window[++i];
    }
  }
 