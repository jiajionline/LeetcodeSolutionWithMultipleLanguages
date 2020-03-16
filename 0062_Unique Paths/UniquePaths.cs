public class Solution {
   private Dictionary<string,int> dict = new Dictionary<string,int>();
   public int UniquePaths(int m, int n) {
       if(m<1 || n<1) return 0;
       if(m==1 || n==1) return 1;
       var key = string.Format("{0}_{1}",m,n);
       if(dict.ContainsKey(key)){
           return dict[key];
       }else{
           var ret = UniquePaths(m-1,n) + UniquePaths(m,n-1);
           dict.Add(key,ret);
           return ret;
       }
   }
}
