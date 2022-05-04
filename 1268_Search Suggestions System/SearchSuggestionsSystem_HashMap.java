class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Map<String, List<String>> map = new HashMap<>();
        for(String product : products) {
            for(int i=1;i<=product.length();i++) {
                String sub = product.substring(0,i);
                map.putIfAbsent(sub, new ArrayList<String>());
                map.get(sub).add(product);
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        for(int i=1;i<=searchWord.length();i++) {
            String sub = searchWord.substring(0, i);
            List<String> l = new ArrayList<String>();
            if(map.containsKey(sub)) {
                List<String> list = map.get(sub);
                for(int j=0;j< Math.min(3, list.size()); j++)
                    l.add(list.get(j));
            }
            
            ans.add(l);

        }
        
        return ans;
    }
}