class MagicDictionary {
    private Map<String,Set<Character>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String str : dictionary) {
            char[] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++) {
                char original = chars[i];
                chars[i] = '*';
                String newStr = new String(chars);
                map.putIfAbsent(newStr, new HashSet<Character>());
                map.get(newStr).add(original);
                chars[i] = original;
            }
        }
    }
    
    public boolean search(String searchWord) {
        char[] chars = searchWord.toCharArray();
        for(int i=0;i<chars.length;i++) {
            char original = chars[i];
            chars[i] = '*';
            String newStr = new String(chars);
            if(map.containsKey(newStr)){
                Set<Character> set = map.get(newStr);
                if(set.size() > 1) return true;
                if(!set.contains(original)) return true;
            }
            chars[i] = original;
        }

        return false;
    }
}