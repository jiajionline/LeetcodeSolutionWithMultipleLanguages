public class Solution {
    public string ShiftingLetters (string S, int[] shifts) {
        if (string.IsNullOrEmpty (S) || shifts == null || S.Length != shifts.Length) return "";
        var ans = new char[S.Length];
        var totalShiftTime = 0;
        for (int i = shifts.Length - 1; i >= 0; i--) {
            totalShiftTime += (shifts[i] % 26);
            char newC = (char) ((S[i] - 'a' + totalShiftTime) % 26 + 'a');
            ans[i] = newC;
        }

        return new String (ans);
    }
}