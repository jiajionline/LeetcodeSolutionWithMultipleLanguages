class Solution {
    private Set<String> perfectSet;
    private Map<String, String> loweredMap;
    private Map<String, String> vowMap;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        perfectSet = new HashSet();
        loweredMap = new HashMap();
        vowMap = new HashMap();

        for (String word: wordlist) {
            perfectSet.add(word);

            String loweredWord = word.toLowerCase();
            loweredMap.putIfAbsent(loweredWord, word);

            String wildWord = convertWild(loweredWord);
            vowMap.putIfAbsent(wildWord, word);
        }

        String[] ans = new String[queries.length];
        int t = 0;
        for (String query: queries)
            ans[t++] = solve(query);
        return ans;
    }

    public String solve(String query) {
        if (perfectSet.contains(query))
            return query;

        String loweredQuery = query.toLowerCase();
        if (loweredMap.containsKey(loweredQuery))
            return loweredMap.get(loweredQuery);

        String wildQuery = convertWild(loweredQuery);
        if (vowMap.containsKey(wildQuery))
            return vowMap.get(wildQuery);

        return "";
    }

    public String convertWild(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c: word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}