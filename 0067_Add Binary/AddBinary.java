class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int v = carry;
            carry = 0;
            if(p1 >= 0) {
                v += a.charAt(p1--) - '0';
            }

            if(p2 >= 0) {
                v += b.charAt(p2--) - '0';
            }

            carry = v / 2;
            v %= 2;
            sb.insert(0, v);
        }

        return sb.toString();
    }
}