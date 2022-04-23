public class Solution {
  
  public String reverseWords(String s) {
    if (s == null) return null;
    
    char[] chars = s.toCharArray();
    int n = chars.length;
    
    reverse(chars, 0, n - 1);
    reverseWords(chars, n);
    return cleanSpaces(chars, n);
  }
  
  void reverseWords(char[] chars, int n) {
    int i = 0, j = 0;
      
    while (i < n) {
      while (i < j || i < n && chars[i] == ' ') i++; // skip spaces
      while (j < i || j < n && chars[j] != ' ') j++; // skip non spaces
      reverse(chars, i, j - 1);                      // reverse the word
    }
  }
  
  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] chars, int n) {
    int i = 0, j = 0;
      
    while (j < n) {
      while (j < n && chars[j] == ' ') j++;             // skip spaces
      while (j < n && chars[j] != ' ') chars[i++] = chars[j++]; // keep non spaces
      while (j < n && chars[j] == ' ') j++;             // skip spaces
      if (j < n) chars[i++] = ' ';                      // keep only one space
    }
  
    return new String(chars, 0, i);
  }
  
  // reverse chars[] from chars[i] to chars[j]
  private void reverse(char[] chars, int i, int j) {
    while (i < j) {
      char t = chars[i];
      chars[i++] = chars[j];
      chars[j--] = t;
    }
  }
  
}