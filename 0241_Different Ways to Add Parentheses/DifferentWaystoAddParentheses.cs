public class Solution {
    public IList<int> DiffWaysToCompute (string input) {
        IList<int> ret = new List<int> ();
        if (string.IsNullOrEmpty (input)) return ret;
        for (int i = 0; i < input.Length; i++) {
            var c = input[i];
            if (c == '+' || c == '-' || c == '*') {
                var left = DiffWaysToCompute (input.Substring (0, i));
                var right = DiffWaysToCompute (input.Substring (i + 1));
                foreach (var p in left) {
                    foreach (var q in right) {
                        switch (c) {
                            case '+':
                                ret.Add (p + q);
                                break;
                            case '-':
                                ret.Add (p - q);
                                break;
                            case '*':
                                ret.Add (p * q);
                                break;
                        }
                    }
                }
            }
        }

        if (ret.Count == 0) ret.Add (System.Convert.ToInt32 (input));
        return ret;
    }
}