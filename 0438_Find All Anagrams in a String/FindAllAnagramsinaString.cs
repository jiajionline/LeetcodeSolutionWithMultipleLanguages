public class Solution {
   public IList<int> FindAnagrams(string s, string p) {
       var ret = new List<int>();
       if(string.IsNullOrEmpty(s) || string.IsNullOrEmpty(p)) return ret;
       if(s.Length < p.Length) return ret;

       int[] arr = new int[26];

       for(int i=0;i<p.Length;i++)
       {
           arr[p[i] - 'a']++;
       }

       for(int i=0;i<p.Length;i++)
       {
           arr[s[i] - 'a']--;
       }

       if(IsAnagrams(arr)){
           ret.Add(0);
       }

       for(int i=p.Length;i<s.Length;i++)
       {
           var begin = i - p.Length;
           arr[s[begin] - 'a']++;
           arr[s[i] - 'a']--;
           if(IsAnagrams(arr)) ret.Add(begin+1);
       }

       return ret;
   }

   private bool IsAnagrams(int[] arr)
   {
       foreach(var i in arr){
           if(i!=0) return false;
       }

       return true;
   }
}
