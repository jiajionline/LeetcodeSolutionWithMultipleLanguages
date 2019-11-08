 public class MagicDictionary
    {
        private Dictionary<string, HashSet<char>> dictionary;
        /** Initialize your data structure here. */
        public MagicDictionary()
        {
            dictionary = new Dictionary<string, HashSet<char>>();
        }
 
        /** Build a dictionary through a list of words */
        public void BuildDict(string[] dict)
        {
            var sb = new StringBuilder();
 
            foreach (var str in dict)   
            {
                for(int i=0;i<str.Length;i++)
                {
                    sb.Clear();
                    sb.Append(str);
                    sb[i] = '*';
                    var newstr = sb.ToString();
 
                    if (!dictionary.ContainsKey(newstr))
                    {
                        dictionary.Add(newstr, new HashSet<char>());
                    }
                    
                    dictionary[newstr].Add(str[i]);
                }
            }
        }
 
        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public bool Search(string word)
        {
            var sb = new StringBuilder();
            for (int i = 0; i < word.Length; i++)
            {
                sb.Clear();
                sb.Append(word);
                sb[i] = '*';
                var newstr = sb.ToString();
                if (dictionary.ContainsKey(newstr))
                {
                    var set = dictionary[newstr];
                    if (set.Count > 1) return true;
                    if (!set.Contains(word[i])) return true;
                }
            }
 
            return false;
        }
    }
 
    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.BuildDict(dict);
     * bool param_2 = obj.Search(word);
     */
