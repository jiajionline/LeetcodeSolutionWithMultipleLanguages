class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int[] occurences = new int[26];
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        int ans = 0;
        
        for(int i=0;i<words.length-1;i++) {
            
            Arrays.fill(occurences, 0);
            for(char c : words[i].toCharArray()) occurences[c-'a']++;
            
            for(int j=i+1;j<words.length;j++) {
                
                boolean notShare = true;
                for(char c : words[j].toCharArray()) 
                {
                     if(occurences[c-'a'] > 0) {
                         notShare = false;
                         break;
                     }
                }
                
                if(notShare)
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        
        return ans;
    }
}