class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }

        Arrays.sort(freq);

        int k = freq[25];
        int p = 1;
        for(int i=24;i>=0;i--){
            if(freq[i] == k) p++;
        }

        return Math.max(tasks.length, (k-1)*(n+1)+p);
    }
}