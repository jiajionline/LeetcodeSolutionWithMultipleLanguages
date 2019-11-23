using System.Collections.Generic;
using System.Linq;

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
            var cnt = q.Count();
            for (int i = 0; i < cnt; i++)
            {
                var w = q.Dequeue();
                var chArr = w.ToCharArray();
                for (int j = 0; j < w.Length; j++)
                {
                    var w_c = w[j];
                    for (var c = 'a'; c <= 'z'; c++)
                    {
                        if (c == w_c) continue;
                        chArr[j] = c;
                        var tmp_s = new string(chArr);
                        if (!set.Contains(tmp_s)) continue;
                        if (endWord.Equals(tmp_s)) return step + 1;
                        set.Remove(tmp_s);
                        q.Enqueue(tmp_s);
                    }

                    chArr[j] = w[j];
                }
            }
        }

        return 0;
    }
}