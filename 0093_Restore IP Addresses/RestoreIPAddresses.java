class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        String ip = "";
        DFS(0, s, ip, ans);
        return ans;
    }

    private void DFS(int step, String s, String ip, List<String> ans) {
        int L = s.length();
        if (step == 4) {
            if (L == 0)
                ans.add(ip);
            return;
        }
        
        if(L == 0) return;

        for (int i = 1; i <= Math.min(3, s.charAt(0) == '0' ? 1 : L); i++) {
            String ss = s.substring(0, i);
            if (i == 3 && Integer.parseInt(ss) > 255)
                return;
            DFS(step + 1, s.substring(i), ip + (step == 0 ? "" : ".") + ss, ans);
        }
    }
}