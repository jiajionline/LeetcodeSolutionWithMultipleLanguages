import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] ret = new int[nums.length - k + 1];
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                max.offer(nums[i]);
            } else {
                ret[i - k] = max.peek();
                max.remove(nums[i - k]);
                max.offer(nums[i]);
            }
        }

        ret[ret.length - 1] = max.peek();
        return ret;
    }
}
