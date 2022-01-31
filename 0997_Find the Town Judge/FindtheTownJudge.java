class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) {
            if(trust.length == 0) return 1;
            else return -1;
        }
        
        int[] votes = new int[n+1];
        for(int i=0;i<trust.length;i++)
            votes[trust[i][1]]++;
        
        int count = votes[0];
        int judge = 0;
        for(int i=1;i<votes.length;i++) {
            if(votes[i] > count) {
                count = votes[i];
                judge = i;
            }
        }
        
        if(count == n-1) {
            for(int i=0;i<trust.length;i++)
                if(trust[i][0] == judge) return -1;
            return judge;
        }
        
        return -1;
    }
}