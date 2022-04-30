class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b) -> Integer.compare(a[0], b[0]));
        int far = 0;
        int i = 0;
        int count = 0;
        
        while(i < clips.length) {
            int nextFar = far;
            while( i < clips.length && clips[i][0] <= far) {
                nextFar = Math.max(nextFar, clips[i][1]);
                i++;
            }
            
            count++;
            
            if(nextFar >= time) return count;
            else if(nextFar == far) return -1;
            
            far = nextFar;
        }
        
        return -1;
    }
}