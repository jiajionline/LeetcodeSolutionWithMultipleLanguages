class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        if(cpdomains == null || cpdomains.length == 0) return ans;
        
        // key is domain, value is the visit count
        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] strs = cpdomain.split("\\s+");
            int count = Integer.valueOf(strs[0]);
            
            String[] parts = strs[1].split("\\.");
            for(int i=0;i<parts.length;i++) {
                String domain = "";
                for(int j=i; j < parts.length;j++) {
                    domain = domain + parts[j];
                    if(j + 1 < parts.length) domain = domain + ".";
                }
                 map.put(domain, map.getOrDefault(domain, 0) + count);
                
            }
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        
        return ans;
    }
}