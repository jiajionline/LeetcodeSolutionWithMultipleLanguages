class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b) -> Integer.compare(a[0], b[0]));
        int currFar = 0;
        int i = 0;
        int count = 0;
        
        while(i < clips.length) {
            int nextFar = currFar;
            // if current start of the clip is less and equals to the currFar, 
            // so the clip overlapped with its previous, we can decide the nextFar
            while( i < clips.length && clips[i][0] <= currFar) {
                nextFar = Math.max(nextFar, clips[i][1]);
                i++;
            }
            
            count++;
            
            if(nextFar >= time) return count;
            else if(nextFar == currFar) return -1;
            
            currFar = nextFar;
        }
        
        return -1;
    }
}