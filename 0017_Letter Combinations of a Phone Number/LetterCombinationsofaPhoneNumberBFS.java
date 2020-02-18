class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();

        String[] dict = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String t : ans) {
                String s = dict[Character.getNumericValue(digit)];
                for (int i = 0; i < s.length(); ++i)
                    tmp.add(t + s.charAt(i));
            }
            ans = tmp;
        }

        return ans;
    }
}