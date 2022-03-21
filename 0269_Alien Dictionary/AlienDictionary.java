class Solution {
    public String alienOrder(String[] words) {
        
        // crate a graph
        Map<Character, List<Character>> adjList = new HashMap<>();
        // how many other chars points to the key char
        Map<Character, Integer> counts = new HashMap<>();
        // just initialize
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        // Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1. like  abc , ab is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        // bfs
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // find all root node (the nodes doesn't have other nodes point to, these node should come first)
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                // remove the parent
                counts.put(next, counts.get(next) - 1);
                // if no parent, just remove from counts and put into queue for next iteration
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}