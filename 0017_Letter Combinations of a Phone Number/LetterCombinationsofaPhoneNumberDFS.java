class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;

        String[] dict = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        char[] cur = new char[digits.length()];
        DFS(digits, dict, 0, cur, ans);
        return ans;
    }

    private void DFS(String digits, String[] dict, int index, char[] cur, List<String> ans) {
        if (index == digits.length()) {
            ans.add(new String(cur));
            return;
        }

        String s = dict[Character.getNumericValue(digits.charAt(index))];

        for (int i = 0; i < s.length(); ++i) {
            cur[index] = s.charAt(i);
            DFS(digits, dict, index + 1, cur, ans);
        }
    }
}