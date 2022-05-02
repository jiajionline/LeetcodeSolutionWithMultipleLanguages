class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        Map<Character, Integer> map = build();
        while(i < s.length()) {
            char c = s.charAt(i);
            if((c == 'I' || c == 'X' || c == 'C') && (i+1 < s.length())) {
                char nextC = s.charAt(i+1);
                if((c == 'I' && (nextC == 'V' || nextC == 'X')) ||
                   (c == 'X' && (nextC == 'L' || nextC == 'C')) ||
                   (c == 'C' && (nextC == 'D' || nextC == 'M'))){
                    ans += (map.get(nextC) - map.get(c));
                    i += 2;
                    continue;
                }
            }
        
            ans += map.get(c);
            i++;
        }
                   
        return ans;
    }
    
    private Map<Character, Integer> build() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        return map;
    }
}