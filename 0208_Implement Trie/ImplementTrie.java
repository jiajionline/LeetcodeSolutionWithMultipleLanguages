class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(p.children[c - 'a'] == null) p.children[c-'a'] = new TrieNode();
            p = p.children[c - 'a'];
        }
        
        p.hasWord = true;
    }
    
    public boolean search(String word) {
        TrieNode p = innerSearch(word);
        return p!= null && p.hasWord;
    }
    
    public boolean startsWith(String prefix) {
        return innerSearch(prefix) != null;
    }
    
    private TrieNode innerSearch(String word) {
        TrieNode p = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(p.children[c - 'a'] == null) return null; 
            p = p.children[c - 'a'];
        }
        
        return p;
    }
    
    class TrieNode{
        TrieNode[] children;
        boolean hasWord;
        public TrieNode(){
            children = new TrieNode[26];
            hasWord = false;
        }
    }
}