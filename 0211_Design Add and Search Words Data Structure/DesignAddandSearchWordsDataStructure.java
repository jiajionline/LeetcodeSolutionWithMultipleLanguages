class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    private boolean helper(String word, int index, TrieNode node) {
        if(word.length() == index) return node.isWord;
        char c = word.charAt(index);
        if(c != '.')
            return node.children[c - 'a'] != null && helper(word, index+1, node.children[c-'a']);
        
        for(int i=0;i<node.children.length;i++)
            if(node.children[i] != null && helper(word, index + 1, node.children[i])) return true;
        
        return false;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}