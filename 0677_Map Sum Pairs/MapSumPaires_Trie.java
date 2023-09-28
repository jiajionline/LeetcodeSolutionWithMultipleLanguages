class MapSum {
    private TireNode root;
    private Map<String,Integer> map;
    public MapSum() {
        root = new TireNode(0);
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int offset = val - map.getOrDefault(key, 0);
        map.put(key, val);
        
        TireNode p = root;
        
        for(char c : key.toCharArray()) {
            if(p.children[c-'a'] == null) 
                p.children[c-'a'] = new TireNode(offset);
            else {
                p.children[c-'a'].val += offset;
            }
            p = p.children[c-'a'];
        }
    }
    
	public int sum(String prefix) {
		TireNode p = root;
		int sum = 0;
		for (char c : prefix.toCharArray()) {
			if (p.children[c - 'a'] != null) {
				p = p.children[c - 'a'];
                sum = p.val;
			} else {
				return 0;
			}
		}

		return sum;
	}
    
	private class TireNode {
	    TireNode[] children = new TireNode[26];
	    int val;
	    public TireNode(int v) {
	        val = v;
	    }
	}
}