public class Solution
{
    public int LadderLength(string beginWord, string endWord, IList<string> wordList)
    {
        var set = new HashSet<string>(wordList);
        if (!set.Contains(endWord)) return 0;
        var q = new Queue<string>();
        q.Enqueue(beginWord);
        var step = 0;
        while (q.Count() > 0)
        {
            step++;
            var size = q.Count();
            while (size-- > 0)
            {
                var curr = q.Dequeue();
                var c_arr = curr.ToCharArray();
                for (int i = 0; i < curr.Length; i++)
                {
                    var w_c = curr[i];
                    for (var c = 'a'; c <= 'z'; c++)
                    {
                        if (c == w_c) continue;
                        c_arr[i] = c;
                        var tmp_s = new string(c_arr);
                        if (!set.Contains(tmp_s)) continue;
                        if (endWord.Equals(tmp_s)) return step + 1;
                        set.Remove(tmp_s);
                        q.Enqueue(tmp_s);
                    }

                    c_arr[i] = curr[i];
                }
            }
        }

        return 0;
    }
}