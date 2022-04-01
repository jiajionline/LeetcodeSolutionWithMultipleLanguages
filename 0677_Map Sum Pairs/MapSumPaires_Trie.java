class MapSum {
    private Tire root;
    private Map<String,Integer> map;
    public MapSum() {
        root = new Tire(0);
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int offset = val;
        if(map.containsKey(key)) {
            offset = val - map.get(key);
        }
        
        map.put(key, val);
        
        Tire p = root;
        
        for(Character c : key.toCharArray()) {
            if(p.nodes[c-'a'] == null) 
                p.nodes[c-'a'] = new Tire(offset);
            else {
                p.nodes[c-'a'].val += offset;
            }
            p = p.nodes[c-'a'];
        }
        
    }
    
	public int sum(String prefix) {
		Tire p = root;
		int sum = 0;
		for (Character c : prefix.toCharArray()) {
			if (p.nodes[c - 'a'] != null) {
				p = p.nodes[c - 'a'];
                sum = p.val;
			} else {
				return 0;
			}
		}

		return sum;
	}
    
	private class Tire {
	    Tire[] nodes = new Tire[26];
	    int val;
	    public Tire(int v) {
	        val = v;
	    }
	}
}