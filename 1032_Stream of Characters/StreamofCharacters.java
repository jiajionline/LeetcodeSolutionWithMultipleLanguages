class StreamChecker {

    private TrieNode root;
    private StringBuilder sb;
    public StreamChecker(String[] words) {
        root = buildTrie(words);
        sb = new StringBuilder();
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode p = root;
        for(int i=sb.length()-1;i>=0;i--) {
            char c = sb.charAt(i);
            if(p.children[c-'a'] == null) return false;
            p = p.children[c-'a'];
            if(p.isWord) return true;
        }
        
        return false;
    }
    
    private TrieNode buildTrie(String[] words) {
        root = new TrieNode();
        for(String s : words) {
            TrieNode p = root;
            for(int i=s.length()-1;i>=0;i--) {
                char c = s.charAt(i);
                if(p.children[c-'a'] == null) p.children[c-'a'] = new TrieNode();
                p = p.children[c-'a'];
            }
            p.isWord = true;
        }
        
        return root;
    }
}

class TrieNode {
    boolean isWord = false;
    TrieNode[] children = new TrieNode[26];
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */