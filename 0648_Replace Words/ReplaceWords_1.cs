public class Solution
{
    public string ReplaceWords(IList<string> dict, string sentence)
    {
        StringBuilder sb = new StringBuilder();
        TrieNode root = BuildTrieNode(dict);

        var stringArray = sentence.Split(" ".ToCharArray());
        foreach (var s in stringArray)
        {
            TrieNode current = root;
            for (int i = 0; i < s.Length; i++)
            {
                var next = current.Get(s[i] - 'a');
                if (next == null || i == s.Length - 1)
                {
                    sb.Append(s + " ");
                    break;
                }
                else if (next.Value != null)
                {
                    sb.Append(next.Value + " ");
                    break;
                }
                else
                {
                    current = next;
                }
            }
        }

        return sb.ToString().TrimEnd();
    }

    private TrieNode BuildTrieNode(IList<string> dict)
    {
        TrieNode root = new TrieNode();

        foreach (var s in dict)
        {
            BuildTrieNode(root, s);
        }

        return root;
    }

    private void BuildTrieNode(TrieNode root, string s)
    {
        TrieNode current = root;
        for (int i = 0; i < s.Length; i++)
        {
            current.Add(s[i]);
            current = current.Get(s[i] - 'a');
            if ((i + 1) == s.Length)
            {
                current.Value = s;
            }
        }
    }
}

class TrieNode
{
    private TrieNode[] nodes = new TrieNode[26];
    public string Value { get; set; }

    public void Add(char c)
    {
        if (nodes[c - 'a'] == null)
        {
            nodes[c - 'a'] = new TrieNode();
        }
    }

    public TrieNode Get(int index)
    {
        return nodes[index];
    }
}
