class Solution {
    public int largestRectangleArea(int[] heights) {
        List<Integer> l = new ArrayList<Integer>();
        for(Integer h : heights){
            l.add(h);
        }

        l.add(0);

        int n = l.size();
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        int i = 0;
        while (i < n) {
          if (s.empty() || l.get(i) >= l.get(s.peek())) {
            s.push(i++);
          } else {
            int h = l.get(s.peek()); 
            s.pop();
            int w = s.empty() ? i : i - s.peek() - 1;        
            ans = Math.max(ans, h * w);
          }
        }
        return ans;
      }
    }