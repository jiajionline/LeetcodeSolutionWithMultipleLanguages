class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> list : synonyms) {
            for(String s : list) {
                map.putIfAbsent(s, new HashSet<String>());
                map.get(s).addAll(list);
            }
        }
        
        String[] texts = text.split("\\s");
        List<String> ans = new ArrayList<String>();
        ans.add("");
        
        for(int i=0;i<texts.length;i++) {
            String s = texts[i];
            List<String> tmpList = new ArrayList<>();
            for(String oldS : ans) {
                Set<String> tmpSet = new HashSet<>();
                DFS(map, s, new HashSet<String>(), tmpSet);
                List<String> collList = new ArrayList<>(tmpSet);
                Collections.sort(collList);
                for(String newText : collList) {
                    if(i != texts.length - 1) {
                        tmpList.add(oldS + newText + " ");
                    }else{
                        tmpList.add(oldS + newText);
                    }
                }    
            }
            
            ans = tmpList;
        }
        
        return ans;
    }
    
    private void DFS(Map<String, Set<String>> map, String s, Set<String> visited, Set<String> set) {
        if(visited.contains(s)) return;
        visited.add(s);
        set.add(s);
        if(!map.containsKey(s)) return;
        for(String tmpS : map.get(s)) {
            DFS(map, tmpS, visited, set);
        }
    }
}