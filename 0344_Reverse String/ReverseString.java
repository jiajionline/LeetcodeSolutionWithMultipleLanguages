
public class ReverseString {
    public String reverseString(String s) {
        if(s==null || s.length() <=1) return s;
        char[] charArray = s.toCharArray();
        
        for(int i=0;i<charArray.length/2;i++){
        	char temp = charArray[charArray.length - 1-i];
        	charArray[charArray.length - 1 -i] = charArray[i];
        	charArray[i] = temp;
        }
        
        return new String(charArray);
    }
}
