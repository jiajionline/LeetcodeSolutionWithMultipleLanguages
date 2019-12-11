class Solution {
    public String reverseWords(String s) {
        if(s == null) return s;
        char[] s_arr = s.toCharArray();
        reverse(s_arr, 0, s_arr.length-1);
        reverseWords(s_arr);
        return cleanSpaces(s_arr);
    }

    private void reverseWords(char[] s_arr){
        int n = s_arr.length;
        int b = 0, e=0;

        while(b<n){
            while(b<e || (b<n && s_arr[b]==' ')) b++; //find the first word which is not space
            while(e<b || (e<n && s_arr[e]!=' ')) e++; //find the first word which is space
            reverse(s_arr, b, e-1);
        }
    }

    private String cleanSpaces(char[] s_arr){
        int n = s_arr.length;
        int b = 0, e =0;

        while(e<n){
            while(e<n && s_arr[e] == ' ') e++; //find the first word which is not space
            while(e<n && s_arr[e] != ' ') s_arr[b++] = s_arr[e++]; //copy the whole word from e to b
            while(e<n && s_arr[e] == ' ') e++; //continue to find the first word which is not space. The purpose of doing it is for the last word contains multiple spaces.
            //if not ending, it should append a space after b,but for the last word, it shouldn't do it.
            if(e<n){
                s_arr[b++] = ' ';
            }
        }

        return new String(s_arr).substring(0,b);
    }

    private void reverse(char[] s_arr, int b,int e){
        while(b < e){
            char tmp = s_arr[b];
            s_arr[b++] = s_arr[e];
            s_arr[e--] = tmp;
        }
    }
}