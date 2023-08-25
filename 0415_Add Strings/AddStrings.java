class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        boolean carry = false;
        StringBuilder ans = new StringBuilder();
        while(index1 >= 0 || index2 >= 0 || carry) {
            int v = 0;
            if(index1 >= 0) v += (num1.charAt(index1--) - '0');
            if(index2 >= 0) v += (num2.charAt(index2--) - '0');
            if(carry) v++;
            carry = (v >= 10);
            v %= 10;
            ans.insert(0, v);
        }
        return ans.toString();
    }
}