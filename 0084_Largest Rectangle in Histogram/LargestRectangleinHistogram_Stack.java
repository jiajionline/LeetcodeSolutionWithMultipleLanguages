class Solution {
      public int largestRectangleArea(int[] heights) {
          int n = heights.length;
          int[] arr = new int[n+1];
          System.arraycopy(heights,0,arr,0,n);
          
          Stack<Integer> stack = new Stack<>();
          int i = 0, ans = 0;
          while(i < n+1) {
              if(stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                  stack.push(i++);
              }else{
                  int h = arr[stack.peek()];
                  stack.pop();
                  int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                  ans = Math.max(ans, w * h);
              }
          }
          
          return ans;
      }
  }