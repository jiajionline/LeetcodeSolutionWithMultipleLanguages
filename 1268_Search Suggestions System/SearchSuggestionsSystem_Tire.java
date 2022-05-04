class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root = new Trie();
        for (String p : products) {
            insert(p, root);
        }
        return search(searchWord, root);
    }
    
    private void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) {
            if (t.sub[c - 'a'] == null)
                t.sub[c - 'a'] = new Trie();
            t = t.sub[c - 'a'];
            if(t.list.size() < 3) t.list.add(p);
        }
    }
    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            if (root != null)
                root = root.sub[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.list);
        }
        return ans;
    }
    
    class Trie {
        Trie[] sub = new Trie[26];
        List<String> list = new ArrayList<>();
    }
}