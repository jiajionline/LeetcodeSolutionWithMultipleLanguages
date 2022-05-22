class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        TrieNode root = new TrieNode();
        for(int v : nums) root.addNumber(root, v);
        
        for(int v : nums) ans = Math.max(ans, root.findMaxXor(root, v));
        
        return ans;
    }
}

class TrieNode {
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[2];
    }
    
    public void addNumber(TrieNode root, int num) {
        TrieNode cur = root;
        for(int i=31;i>=0;i--) {
            int curBit = (num >> i) & 1;
            if(cur.children[curBit] == null) cur.children[curBit] = new TrieNode();
            cur = cur.children[curBit];
        }
    }
    
    public int findMaxXor(TrieNode root, int num) {
        int sum = 0;
        TrieNode cur = root;
        for(int i=31;i>=0;i--) {
            int curBit = (num >> i) & 1;
            int other = curBit == 1 ? 0 : 1;
            if(cur.children[other] == null) {
                cur = cur.children[curBit];
            }else {
                sum += (1 << i);
                cur = cur.children[other];
            }
        }
        
        return sum;
    }
}