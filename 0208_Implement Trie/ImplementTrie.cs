public class Trie {
    private TrieNode header;
    /** Initialize your data structure here. */
    public Trie() {
        header = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void Insert(string word) {
        var curr = header;
        for(int i=0;i<word.Length;i++){
            
            if(curr.Children[word[i] - 'a'] == null){
                curr.Children[word[i] - 'a'] = new TrieNode();
            }
        
            curr = curr.Children[word[i] -'a'];
        }
        
        curr.IsWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        var node = Find(word);
        return node!=null && node.IsWord ? true : false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        var node = Find(prefix);
        return node!=null;
        
    }
    
    private TrieNode Find(string s){
        var curr = header;
        var index = 0;
        while(index < s.Length && curr!=null){
            curr = curr.Children[s[index++] - 'a'];
        }
        
        return curr;
    }
}

public class TrieNode{
    public TrieNode[] Children = new TrieNode[26];
    public bool IsWord;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */