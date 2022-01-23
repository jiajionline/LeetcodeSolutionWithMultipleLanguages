public class Solution {
    public string ReplaceWords(IList<string> dictionary, string sentence) {
        dictionary = dictionary.OrderBy(x => x.Length).ToList();
        
        var words = sentence.Split(" ");
        var ans = new List<string>();
        
        foreach(var word in words)
        {
            var inserted = false;
            foreach(var root in dictionary)
            {
                if(word.StartsWith(root))
                {
                    ans.Add(root);
                    inserted = true;
                    break;
                }
            }
            
            if(!inserted) ans.Add(word);
        }
        
        return string.Join(" ", ans);
    }
}