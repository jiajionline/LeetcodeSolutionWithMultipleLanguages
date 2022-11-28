/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            for(int i=0;i<n;i++){
                if(isCelebrity(i, n)) return i;
            }
            
            return -1;
        }
        
        private boolean isCelebrity(int i, int n) {
            for(int j=0;j<n;j++) {
                if(i == j) continue;
                if(knows(i,j) || !knows(j,i)) return false;
            }
            
            return true;
        }
    }