class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arrLP = new int[26];
        for(char c : licensePlate.toCharArray()) {
            if(Character.isLetter(c)) {
                arrLP[Character.toLowerCase(c) - 'a']++;
            }
        }

        String ans = "";

        for(String word : words) {
            if(ans.length() > 0 && (ans.length() <= word.length())) continue;
            int[] copy = new int[26];
            System.arraycopy(arrLP,0, copy,0, arrLP.length);
            if(isCompleting(copy, word)) {
                ans = word;
            }
        }

        return ans;
    }

    private boolean isCompleting(int[] arr, String str) {
        for(char c : str.toCharArray()) {
            if(Character.isLetter(c)) {
                arr[c - 'a']--;
            }
        }

        for(int v : arr){
            if(v > 0) return false;
        }

        return true;
    }
}