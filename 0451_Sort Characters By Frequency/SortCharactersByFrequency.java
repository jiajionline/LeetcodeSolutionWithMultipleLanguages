class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
                
        List<Character> characters = new ArrayList<>(counts.keySet());        
        Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            int t = counts.get(c);
            for (int i = 0; i < t; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}