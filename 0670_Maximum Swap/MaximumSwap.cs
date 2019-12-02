public class Solution {
    public int MaximumSwap (int num) {
        if (num < 10) return num;
        var charArr = num.ToString ().ToCharArray ();
        var buckets = new int[10];
        for (int i = 0; i < charArr.Length; i++) {
            buckets[charArr[i] - '0'] = i;
        }

        for (int i = 0; i < charArr.Length; i++) {
            for (int k = 9; k > charArr[i] - '0'; k--) {
                if (buckets[k] > i) {
                    var tmp = charArr[i];
                    charArr[i] = charArr[buckets[k]];
                    charArr[buckets[k]] = tmp;
                    return int.Parse (new string (charArr));
                }
            }
        }

        return num;
    }
}