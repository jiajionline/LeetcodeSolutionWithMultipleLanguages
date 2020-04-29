public class Solution {
    public IList<int> PartitionLabels(string S) {
        var ans = new List<int>();
        var dict = new Dictionary<char,int>();
        for(int i=0;i<S.Length;i++){
            if(dict.ContainsKey(S[i])){
                dict[S[i]] = i;
            }else{
                dict.Add(S[i],i);
            }
        }

        int start = 0;
        int end = 0;
        for(int i=0;i<S.Length;i++){
            if(dict[S[i]] > end){
                end = dict[S[i]];
            }

            if(i == end){
                ans.Add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }
}