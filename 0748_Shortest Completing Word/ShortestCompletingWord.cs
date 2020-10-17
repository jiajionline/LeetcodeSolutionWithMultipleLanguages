public class Solution {
    public string ShortestCompletingWord(string licensePlate, string[] words) {
        Dictionary<char,int> original = new Dictionary<char,int>();
        foreach(var c in licensePlate){
            if(Char.IsLetter(c)){
                var newC = Char.ToLower(c);
                if(!original.ContainsKey(newC)) original.Add(newC, 0);
                original[newC] +=1;
            }
        }
        
        string ans = string.Empty;
        int ansLength = int.MaxValue;
        
        foreach(var word in words){
            if(word.Length > ansLength) continue;
            var copyDict = new Dictionary<char,int>(original);
            foreach(var c in word){
                
                var newC = Char.ToLower(c);
                if(copyDict.ContainsKey(newC)){
                    copyDict[newC] -= 1;
                    if(copyDict[newC] == 0){
                        copyDict.Remove(newC);
                    }
                    
                    if(copyDict.Count == 0){
                        if(ans.Equals(string.Empty) || ans.Length > word.Length){
                            ans = word;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}