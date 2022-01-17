public class Solution {
    public bool WordPattern(string pattern, string s) {
        var words = s.Split(' ');
        if(pattern.Length != words.Count()) return false;
        
        var dictChar = new Dictionary<char, string>();
        var dictWord = new Dictionary<string, char>();
        
        for(int i=0;i<pattern.Length;i++)
        {
            var c = pattern[i];
            var word = words[i];
            
            if(!dictChar.ContainsKey(c))
            {
                if(dictWord.ContainsKey(word)) return false;
                
                dictChar.Add(c, word);
                dictWord.Add(word, c);

            }else{
                var mappedWord = dictChar[c];
                if(!mappedWord.Equals(word)) return false;
            }
        }
        
        return true;
    }
}