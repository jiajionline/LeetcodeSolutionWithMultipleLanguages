class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i=2;i<=n;i++) {
            StringBuilder sb = new StringBuilder();
            int index = 1;
            int count = 1;
            
            while(index < ans.length()) {
                if(ans.charAt(index) != ans.charAt(index-1)) {
                    sb.append("" + count);
                    sb.append(ans.charAt(index-1));
                    count = 1;
                }else{
                    count++;
                }    
                
                index++;
            }
            
            sb.append("" + count);
            sb.append(ans.charAt(index-1));
            ans = sb.toString();
        }
        
        return ans;
    }
}