class Solution {
    public bool ContainsDuplicate (int[] nums) {
        var set = new HashSet<int> ();
        foreach (var i in nums) {
            if (set.Contains (i)) {
                return true;
            } else {
                set.Add (i);
            }
        }

        return false;
    }
}