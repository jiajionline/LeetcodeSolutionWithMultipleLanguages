class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b)-> Integer.compare(a[0], b[0]));
        int curr = 0;
        int ans = 0;
        int i = 0;
        while(i < clips.length) {
            int far = curr;
            // if the start of the clip is less and equals to the curr, 
            // so the clip overlapped with its previous, we can decide the far
            while(i < clips.length && clips[i][0] <= curr) {
                far = Math.max(far, clips[i][1]);
                i++;
            }
            
            ans++;
            
            if(far >= time) return ans;
            // can't move anymore like [0,2] <- curr, far  [4,6]
            else if(far == curr) return -1;
            
            curr = far;
        }
        
        return -1;
    }
}