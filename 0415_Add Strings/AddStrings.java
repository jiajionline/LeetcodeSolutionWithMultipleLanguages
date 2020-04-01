public class Solution {
    public String addStrings(String num1, String num2)
    {
        if (num1 == null || num1.length() == 0 ) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(index1 >=0 || index2 >= 0 || carry > 0)
        {
            int value = 0;
            value += carry;

            if(index1 >= 0)
            {
                value += (num1.charAt(index1--) - '0');
                
            }

            if(index2 >= 0)
            {
                value += (num2.charAt(index2--) - '0');
            }

            carry = value / 10;
            value %= 10;

            sb.append(value);
        }

        return reverse(sb.toString());
    }

    private String reverse(String s)
    {
        char[] charArray = s.toCharArray();
        int i = 0;
        while(i < charArray.length / 2)
        {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
            i++;
        }

        return new String(charArray);
    }
}
