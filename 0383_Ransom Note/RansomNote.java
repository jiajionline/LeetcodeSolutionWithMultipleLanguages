class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for(char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()) {
            if(chars[c - 'a']-- <= 0) return false;
        }

        return true;
    }
}