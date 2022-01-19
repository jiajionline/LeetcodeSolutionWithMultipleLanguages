public class Solution {
    public string FrequencySort(string s)
    {
        Dictionary<char, int> dict = new Dictionary<char, int>();
        foreach(var c in s)
        {
            if (!dict.ContainsKey(c)) dict.Add(c, 0);
                dict[c] += 1;
        }

        var sortedList = dict.ToList().OrderByDescending(n => n.Value);
        var sb = new StringBuilder();
        foreach(var k in sortedList)
        {
            sb.Append(k.Key, k.Value);
        }

        return sb.ToString();
    }
}