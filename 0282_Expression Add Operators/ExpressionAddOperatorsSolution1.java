public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        if(num == null || num.length() == 0) return ans;
        dfs(ans, "", num, target, 0, 0, 0);
        return ans;
    }
    public void dfs(List<String> ans, String exp, String num, int target, int pos, long curr, long prev){
        if(pos == num.length()){
            if(target == curr)
                ans.add(exp);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long n = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                dfs(ans, exp + n, num, target, i + 1, n, n);
            }
            else{
                dfs(ans, exp + "+" + n, num, target, i + 1, curr + n , n);
                
                dfs(ans, exp + "-" + n, num, target, i + 1, curr -n, -n);
                
                dfs(ans, exp + "*" + n, num, target, i + 1, curr - prev + prev * n, prev * n );
            }
        }
    }
}