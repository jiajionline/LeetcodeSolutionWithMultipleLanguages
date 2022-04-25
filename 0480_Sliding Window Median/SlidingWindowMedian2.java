class Solution {
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MeanQueue queue = new MeanQueue();
        double[] ans = new double[n - k + 1];
        
        for(int i = 0; i < n; i++){
            queue.offer(nums[i]);
            if(i + 1 >= k){
                ans[i - k + 1] = queue.getMedian();
                queue.remove(nums[i - k + 1]);
            }
        }

        return ans;
    }
    
    class MeanQueue{
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a)); 
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // min is a Min-heap stores larger half of nums
    
        void offer(int num){
            max.offer(num);     
            min.offer(max.poll());
            
            if(max.size() < min.size()){ // balance, max size always >= min size
                max.offer(min.poll());
            }
        }
        
        double getMedian(){
            return max.size() > min.size() ? max.peek() : (max.peek() / 2.0 + min.peek() / 2.0);
        }
        
        int size(){
            return max.size() + min.size();
        }
        
        void remove(int x){
            if(max.size() > 0 && max.peek() >= x) max.remove(x);
            else min.remove(x);
        }
     
    }
}