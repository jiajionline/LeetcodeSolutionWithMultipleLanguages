class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()) {
            if(p.children[c-'a'] == null) p.children[c-'a'] = new TrieNode();
            p = p.children[c-'a'];
        }
        p.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        return search(word, 0, p);
    }

    private boolean search(String word, int index, TrieNode node) {
        if(index == word.length()) return false;
        char c = word.charAt(index);
        if(c == '.') {
            for(TrieNode child : node.children) {
                if(child != null) {
                    if(index == word.length()-1 && child.isWord) return true;
                    if(search(word, index + 1, child)) return true;
                }
            }
        }else if(node.children[c-'a'] != null) {
            if(index == word.length()-1 && node.children[c-'a'].isWord) return true;
            if(search(word, index + 1, node.children[c-'a'])) return true;
        }

        return false;

    }
}

 class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
 }