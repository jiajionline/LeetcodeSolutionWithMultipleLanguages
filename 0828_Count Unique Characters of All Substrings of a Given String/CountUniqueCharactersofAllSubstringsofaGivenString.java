class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        List<List<Integer>> pos = new ArrayList<>();
        
        for(int i=0;i<26;i++) {
            pos.add(new ArrayList<Integer>());
            pos.get(i).add(-1);
        }
        
        for(int i=0;i<n;i++) {
            pos.get(s.charAt(i) - 'A').add(i);
        }
        
        for(int i=0;i<26;i++) {
            pos.get(i).add(n);
        }
        
        int ans = 0;
        for(int k=0;k<26;k++) {
            for(int i=1; i< pos.get(k).size() - 1;i++) {
                ans += (pos.get(k).get(i) - pos.get(k).get(i-1)) * (pos.get(k).get(i+1) - pos.get(k).get(i));
            }
        }
        
        return ans;
    }
}