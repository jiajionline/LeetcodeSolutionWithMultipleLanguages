class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        // key is username,
        Map<String, List<Pair<Integer, String>>> map = new HashMap<>();
        
        for(int i=0;i<username.length;i++) {
            String userName = username[i];
            int ts = timestamp[i];
            String ws = website[i];
            map.putIfAbsent(userName, new ArrayList<Pair<Integer, String>>());
            map.get(userName).add(new Pair<Integer, String>(ts, ws));
        }
        
        Map<String, Integer> counter = new HashMap<>();
        
        for(List<Pair<Integer, String>> list : map.values()) {
            if(list.size() <= 2) continue;
            Collections.sort(list, (a,b)-> Integer.compare(a.getKey(), b.getKey()));
            Set<String> set = new HashSet<>();
            for(int i=0;i<list.size() - 2;i++) {
                for(int j=i+1;j<list.size() - 1;j++) {
                    for(int k = j+1; k < list.size(); k++) {
                        String a = list.get(i).getValue();
                        String b = list.get(j).getValue();
                        String c = list.get(k).getValue(); 
                        
                        String pattern = a + "-" + b + "-" + c;
                        if(set.contains(pattern)) continue;
                        set.add(pattern);
                        counter.put(pattern, counter.getOrDefault(pattern, 0) + 1);
                    }
                }
            }
        }
        
        List<Pair<String, Integer>> patternToScoreList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : counter.entrySet()) {
            patternToScoreList.add(new Pair<String, Integer>(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(patternToScoreList, (a, b) -> {
            if(a.getValue() == b.getValue()) return a.getKey().compareTo(b.getKey());
            else return b.getValue() - a.getValue();
        });
        
        String finalPattern = patternToScoreList.get(0).getKey();
        
            
        List<String> res = new ArrayList<String>();
        if(finalPattern.length() > 0) {
            String[] arr = finalPattern.split("-");
            for(String s : arr) res.add(s);
        }
        
        return res;
    }
}