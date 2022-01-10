class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();
        
        int p1 = chars_a.length - 1;
        int p2 = chars_b.length - 1;
        int carry = 0;
        
        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int val = 0;
            if(p1 >= 0)
                val += (chars_a[p1--] - '0');
            
            if(p2 >= 0)
                val += (chars_b[p2--] - '0');
            
            val += carry;
            
            carry = val / 2;
            val %=2;
            
            
            sb.insert(0, val);
        }
        
        return sb.toString();
    }
}