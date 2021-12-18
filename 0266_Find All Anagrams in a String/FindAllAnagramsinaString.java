class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray())
        {
            arr[c-'a']++;
        }
        
        int countOfOdd = 0;
        for(int i : arr){
            if(i % 2 == 1) countOfOdd++;
        }
        
        return countOfOdd <= 1;
    }
}