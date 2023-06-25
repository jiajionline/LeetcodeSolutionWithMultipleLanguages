public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length-1);
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0;
        while(l < arr.length) {
            while(l < arr.length && arr[l] == ' ') l++;
            r = l;
            while(r < arr.length && arr[r] != ' ') r++;
            if(l < arr.length) {
                reverse(arr, l , r-1);
                sb.append(arr, l , r-l);
                sb.append(' ');
            }
            l = r;
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void reverse(char[] arr, int l , int r) {
        while(l < r) {
            char c = arr[l];
            arr[l++] = arr[r];
            arr[r--] = c;
        }
    }
}