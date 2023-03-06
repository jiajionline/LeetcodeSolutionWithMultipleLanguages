public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for(String s : strs){
          sb.append(intToString(s.length()));
          sb.append(s.toCharArray());
      }
      
      return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
      List<String> list = new ArrayList<>();
      if(s.isEmpty()) return list;
      int index = 0;
      while(index < s.length()){
          int len = stringToInt(s.substring(index, index+4));
          index+=4;
          list.add(s.substring(index, index+len));
          index+=len;
      }
      
      return list;
  }
  
  private char[] intToString(int x) {
      char[] chars = new char[4];
      for(int i=3;i>=0;i--){
          chars[3-i] = (char)((x >> i * 8) & 0xFF);
      }
      
      return chars;
  }
  
  private int stringToInt(String s) {
      int result = 0;
      for(char c : s.toCharArray()) {
          result = (result << 8) + (int)c;
      }
      return result;
  }
}