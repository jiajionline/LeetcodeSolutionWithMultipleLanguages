// from leetcode solution
public class Codec {
  // Encodes string length to char array
  public char[] intToChars(String s) {
    int x = s.length();
    char[] chars = new char[4];
    for(int i = 3; i > -1; --i) {
      chars[3 - i] = (char) (x >> (i * 8) & 0xff);
    }
    return chars;
  }

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for(String s: strs) {
      sb.append(intToChars(s));
      sb.append(s);
    }
    return sb.toString();
  }

  // Decodes bytes string to integer
  public int stringToInt(String str) {
    int result = 0;
    for(char b : str.toCharArray())
      result = (result << 8) + (int)b;
    return result;
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    int i = 0, n = s.length();
    List<String> ans = new ArrayList();
    while (i < n) {
      int length = stringToInt(s.substring(i, i + 4));
      i += 4;
      ans.add(s.substring(i, i + length));
      i += length;
    }
    return ans;
  }
}