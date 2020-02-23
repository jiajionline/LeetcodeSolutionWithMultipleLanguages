public class MedianFinder {

   private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
   private PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
   /** initialize your data structure here. */
   public MedianFinder() {
      
   }
  
   public void addNum(int num) {
       max.offer(num);
       min.offer(max.poll());
       if(max.size() < min.size())
       {
           max.offer(min.poll());
       }
   }
  
   public double findMedian() {
       if((max.size() + min.size()) % 2 == 0)
       {
           return (max.peek() + min.peek()) * 0.5;
       }else{
           return max.peek();
       }
   }
}

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.AddNum(num);
* double param_2 = obj.FindMedian();
*/

