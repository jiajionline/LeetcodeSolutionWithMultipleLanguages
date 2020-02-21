class Solution {
    private List<String> ans;
    private char[] num;
    private char[] exp;
    private int target;
    
    public List<String> addOperators(String num, int target) {
      this.num = num.toCharArray();
      this.ans = new ArrayList<>();
      this.target = target;
      this.exp = new char[num.length() * 2];
      dfs(0, 0, 0, 0);
      return ans;
    }
    
    private void dfs(int pos, int len, long prev, long curr) {
      if (pos == num.length) {      
        if (curr == target)
          ans.add(new String(exp, 0, len));
        return;
      }
      
      int s = pos;
      int l = len;
      if (s != 0) ++len;
      
      long n = 0;
      while (pos < num.length) {
        if (num[s] == '0' && pos - s > 0) break; // 0X...
        n = n * 10 + (int)(num[pos] - '0');      
        if (n > Integer.MAX_VALUE) break; // too long
        exp[len++] = num[pos++]; // copy exp
        if (s == 0) {
          dfs(pos, len, n, n);
          continue;
        }
        exp[l] = '+'; dfs(pos, len, n, curr + n);
        exp[l] = '-'; dfs(pos, len, -n, curr - n);
        exp[l] = '*'; dfs(pos, len, prev * n, curr - prev + prev * n);
      }
    }
  }