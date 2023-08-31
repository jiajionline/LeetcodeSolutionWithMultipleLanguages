class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }

        int ans = 0;
        for(String word : words) {
            if(isSubsequence(map, word)) ans++;
        }
        return ans;
    }

    private boolean isSubsequence(Map<Character, List<Integer>> map, String word) {
        int prev = -1;
        for(char c : word.toCharArray()) {
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            int l = 0, r = list.size();
            while(l < r) {
                int mid = (r-l)/2 + l;
                if(list.get(mid) > prev){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }

            if(l == list.size()) return false;
            prev = list.get(l);
        }
        return true;
    }
}