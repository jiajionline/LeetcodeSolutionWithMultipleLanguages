class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a,b)-> Integer.compare(a[0], b[0]));
        int ans = 0, curr = 0, index = 0;
        while(index < clips.length) {
            int far = curr;
            // if the start of the clip is less and equals to the curr, 
            // so the clip overlapped with its previous, we can decide the far
            while(index < clips.length && clips[index][0] <= curr){
                far = Math.max(far, clips[index][1]);
                index++;
            }
            ans++;
            if(far >= time) return ans;
            // can't move anymore like [0,2] <- curr, far  [4,6]
            else if(curr == far) return -1;
            
            curr = far;
        }
        // no answer found
        return -1;
    }
}