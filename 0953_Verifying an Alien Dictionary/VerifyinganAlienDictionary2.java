class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = order.length();
        int[] orderMap = new int[128];
        for(int i=0;i<n;i++) {
            orderMap[order.charAt(i)] = i;
        }

        for(int i=1;i<words.length;i++) {
            if(!isSorted(words[i-1], words[i], orderMap)) return false;
        }
        return true;
    }

    private boolean isSorted(String wordA, String wordB,int[] orderMap) {
        int cnt = Math.min(wordA.length(), wordB.length());
        for(int i=0;i<cnt;i++) {
            char charA = wordA.charAt(i);
            char charB = wordB.charAt(i);
            if(orderMap[charA] < orderMap[charB]) return true;
            if(orderMap[charA] > orderMap[charB]) return false;
        }

        if(wordA.length() <= wordB.length()) return true;
        else return false;
    }
}