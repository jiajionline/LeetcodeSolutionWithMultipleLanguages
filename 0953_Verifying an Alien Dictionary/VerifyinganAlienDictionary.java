class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++) {
            map.put(order.charAt(i), i);
        }
        
        for(int i=1;i<words.length;i++) {
            if(!ordered(words[i-1], words[i], map)) return false;
        }
        
        return true;
    }
    
    private boolean ordered(String w1, String w2, Map<Character, Integer> map) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < w1.length() && index2 < w2.length()) {
            int order1 = map.get(w1.charAt(index1));
            int order2 = map.get(w2.charAt(index2));
            
            if(order1 > order2) return false;
            else if(order1 < order2) return true;
            else {
                index1++;
                index2++;
            }
        }
        
        if(index1 < w1.length()) return false;
        else return true;
    }
}