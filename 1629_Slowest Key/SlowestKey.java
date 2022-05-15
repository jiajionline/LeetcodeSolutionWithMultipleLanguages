class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] arr = new int[26];
        arr[keysPressed.charAt(0) - 'a'] = releaseTimes[0];

        for (int i = 1; i < releaseTimes.length; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);
            arr[currentKey - 'a'] = Math.max(arr[currentKey - 'a'], currentDuration);
        }
        
        int ans = 25;
        for (int c = 24; c >= 0; c--) {
            if (arr[c] > arr[ans]) {
                ans = c;
            }
        }
        return (char) (ans + 'a');
    }
}
