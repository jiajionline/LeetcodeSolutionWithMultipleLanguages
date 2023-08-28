class MagicDictionary {
    private Map<String,List<String>> map;

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
                map.putIfAbsent(newStr, new ArrayList<String>());
                map.get(newStr).add(str);
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
                List<String> list = map.get(newStr);
                if(list.size() > 1) return true;
                for(String strInList : list) {
                    if(!searchWord.equals(strInList)) return true;
                }
            }
            chars[i] = original;
        }

        return false;
    }
}