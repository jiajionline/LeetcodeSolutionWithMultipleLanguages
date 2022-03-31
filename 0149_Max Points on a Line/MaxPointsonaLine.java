class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        for(int i=0;i<n;i++) {
            Map<Slope,Integer> map = new HashMap();
            int max = 0;
            int same = 1;
            for(int j=i+1;j<n;j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if(p1[0] == p2[0] && p1[1] == p2[1]) {
                    same++;
                    continue;
                }
                
                Slope slope = getSlope(p1,p2);
                map.put(slope, map.getOrDefault(slope,0) + 1);
                max = Math.max(max, map.get(slope));
            }
            
            ans = Math.max(ans, max + same);
        }
        
        return ans;
    }
    
    private Slope getSlope(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        //vertical
        if(dx == 0) return new Slope(0, p1[0]);
        //horizontal 
        if(dy == 0) return new Slope(p1[1], 0);
        int d = gdc(dx, dy);
        return new Slope(dx/d, dy/d);
    }
    
    private int gdc(int a, int b) {
        return a % b == 0 ? b : gdc(b, a%b);
    }
    
    private class Slope {
        int x;
        int y;
        public Slope(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Slope))
                return false;
            Slope other = (Slope)o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public final int hashCode() {
            int result = 17;
            return 31 * this.x + this.y;
        }
    }
}