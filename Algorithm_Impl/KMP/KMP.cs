using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public static class KMP
{
    public static List<int> Build(string p)
    {
        int m = p.Length;
        var nxt = new List<int> { 0, 0 };

        for (int i = 1, j = 0; i < m; i++)
        {
            while (j > 0 && p[i] != p[j])
                j = nxt[j];
            if (p[i] == p[j])
                j++;
            nxt.Add(j);
        }
        return nxt;
    }

    public static List<int> Match(string s, string p)
    {
        var nxt = Build(p);
        var ans = new List<int>();
        var n = s.Length;
        var m = p.Length;

        for (int i = 0, j = 0; i < n; i++)
        {
            while (j > 0 && s[i] != p[j])
                j = nxt[j];
            if (s[i] == p[j])
                j++;
            if (j == m)
            {
                ans.Add(i - m + 1);
                j = nxt[j];
            }
        }

        return ans;
    }

    public static void CheckEQ(List<int> actual, List<int> expected)
    {
        var actualNotExpected = actual.Except(expected).ToList();
        var expectedNotActual = expected.Except(actual).ToList();

        if (actualNotExpected.Any() || expectedNotActual.Any())
        {
            Console.WriteLine("actual " + string.Join(',', actual) + " expected " + string.Join(',', expected));
        }
        else
        {
            Console.WriteLine("pass.");
        }
    }

    public static void Main(string[] args)
    {

        KMP.CheckEQ(KMP.Build("ABCDABD"), new List<int> { 0, 0, 0, 0, 0, 1, 2, 0 });
        KMP.CheckEQ(KMP.Build("AB"), new List<int> { 0, 0, 0 });
        KMP.CheckEQ(KMP.Build("A"), new List<int> { 0, 0 });
        KMP.CheckEQ(KMP.Build("AA"), new List<int> { 0, 0, 1 });
        KMP.CheckEQ(KMP.Build("AAAA"), new List<int> { 0, 0, 1, 2, 3 });
        KMP.CheckEQ(KMP.Build("AABA"), new List<int> { 0, 0, 1, 0, 1 });


        KMP.CheckEQ(KMP.Match("ABC ABCDAB ABCDABCDABDE", "ABCDABD"), new List<int> { 15 });
        KMP.CheckEQ(KMP.Match("ABC ABCDAB ABCDABCDABDE", "AB"), new List<int> { 0, 4, 8, 11, 15, 19 });
        KMP.CheckEQ(KMP.Match("ABC ABCDAB ABCDABCDABDE", "B"), new List<int> { 1, 5, 9, 12, 16, 20 });
        KMP.CheckEQ(KMP.Match("AAAAA", "A"), new List<int> { 0, 1, 2, 3, 4 });
        KMP.CheckEQ(KMP.Match("AAAAA", "AA"), new List<int> { 0, 1, 2, 3 });
        KMP.CheckEQ(KMP.Match("AAAAA", "AAA"), new List<int> {
            0, 1, 2});
        KMP.CheckEQ(KMP.Match("ABC", "ABC"), new List<int> { 0 });

    }
}

