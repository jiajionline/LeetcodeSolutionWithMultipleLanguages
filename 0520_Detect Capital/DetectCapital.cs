public class Solution {
    public bool DetectCapitalUse(string word) {
        if(String.IsNullOrEmpty(word)) return false;
        char lastC = word[word.Length -1];
        if(lastC >= 'a' && lastC <= 'z'){
            return AllSameCase(word, 1, word.Length - 1, false);
        }else{
            return AllSameCase(word, 0, word.Length - 1, true);
        }
    }
    
    private bool AllSameCase(string word, int s, int e, bool isUpper){
        if(isUpper){
            for(int i=s;i<=e;i++){
                var c = word[i];
                if(c < 'A' || c > 'Z') return false;
            }
        }else{
            
            for(int i=s;i<=e;i++){
                var c = word[i];
                if(c < 'a' || c > 'z') return false;
            }
        }
        
        return true;
    }
}