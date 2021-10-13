public class Solution {
    
    private int ans = int.MaxValue;
    private char[] GENES = new char[]{'A','C','G','T'};
    
    public int MinMutation(string start, string end, string[] bank) {
        if(bank == null || bank.Length == 0) return -1;
        
        var graph = new HashSet<string>();
        foreach(var b in bank)
        {
            graph.Add(b);
        }
        graph.Add(start);
        
        var visited = new HashSet<string>();
        
        DFS(start, end, graph, visited, 0);
        
        return ans == int.MaxValue ? -1 : ans;
    }
    
    private void DFS(string src, string end, HashSet<string> graph, HashSet<string> visited, int mutations)
    {
        
        if(!graph.Contains(src) || visited.Contains(src)) return;
        
        if(src == end)
        {
            ans = Math.Min(mutations, ans);
            return;
        }
        
        
        visited.Add(src);
        
        var char_arr = src.ToCharArray();
        
        for(int i=0;i<src.Length;i++)
        {
            for(int j=0;j<GENES.Length;j++)
            {
                var rawChar = char_arr[i];
                char_arr[i] = GENES[j];
                var newStr = new String(char_arr);
                DFS(newStr, end, graph, visited, mutations+1);
                char_arr[i] = rawChar;
            }
        }
    }
}