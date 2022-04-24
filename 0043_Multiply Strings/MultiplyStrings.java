class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        int[] pos = new int[m+n];
        
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += pos[i+j+1];
                pos[i+j] += product / 10;
                pos[i+j+1] = product % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int v : pos) {
            if(v == 0 && sb.length() == 0) continue;
            sb.append(v);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}