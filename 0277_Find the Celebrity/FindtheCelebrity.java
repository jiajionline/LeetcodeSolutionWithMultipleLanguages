/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int ans = 0;
            // find a candidate (make sure other people are not a celebrity)
            for(int i=1;i<n;i++) {
                if(!knows(i, ans)) ans = i;
            }
            
            // make sure if the candidate is a celebrity
            for(int i=0;i<n;i++) {
                if(ans == i) continue;
                if(knows(ans, i) || !knows(i, ans)) return -1;
            }
            
            return ans;
        }
    }