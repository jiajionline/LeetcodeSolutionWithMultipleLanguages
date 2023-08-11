class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }

        for(char c : t.toCharArray()) {
            arr[c-'a']--;
        }

        char ans = 'a';
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                ans = (char)('a' + i);
            }
        }
        return ans;
    }
}