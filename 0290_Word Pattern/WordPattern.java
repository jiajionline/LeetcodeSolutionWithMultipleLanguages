class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap mapToIndex = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!mapToIndex.containsKey(c))
                mapToIndex.put(c, i);

            if (!mapToIndex.containsKey(word))
                mapToIndex.put(word, i);

            if (mapToIndex.get(c) != mapToIndex.get(word))
                return false;
        }

        return true;
    }
}