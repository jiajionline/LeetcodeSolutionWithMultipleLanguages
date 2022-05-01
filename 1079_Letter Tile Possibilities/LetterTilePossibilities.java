class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for(char c : tiles.toCharArray()) count[c-'A']++;
        return backtracking(count);
    }
    
    private int backtracking(int[] count) {
        int sum = 0;
        for(int i=0;i<count.length;i++) {
            if(count[i] == 0) continue;
            count[i]--;
            sum++;
            sum += backtracking(count);
            count[i]++;
        }
        
        return sum;
    }
}