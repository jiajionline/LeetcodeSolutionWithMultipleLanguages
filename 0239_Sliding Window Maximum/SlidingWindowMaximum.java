import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums == null || nums.length == 0 || k == 0) return nums;
    	
        int[] ans = new int[nums.length - k + 1];
        //Why is ArrayDeque better than LinkedList?
        //https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        Deque<Integer> indices = new ArrayDeque<>();
    
        for (int i = 0; i < nums.length; i++) {
            while (indices.size() > 0 && nums[i] >= nums[indices.getLast()]){
			    indices.removeLast();
			}
            indices.addLast(i);
            if (i - k + 1 >= 0) ans[i - k + 1] = nums[indices.getFirst()];        
            if (i - k + 1 == indices.getFirst()) indices.removeFirst();
        }
             
        return ans;
    }
}