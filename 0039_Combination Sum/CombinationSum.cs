public class Solution {

    public IList<IList<int>> CombinationSum (int[] candidates, int target) {
        IList<IList<int>> ret = new List<IList<int>> ();
        if (candidates == null || candidates.Length == 0) return ret;

        Array.Sort (candidates);

        BackTracking (ret, candidates, new List<int> (), 0, target);

        return ret;
    }

    private void BackTracking (IList<IList<int>> ret, int[] candidates, IList<int> list, int current, int remains) {
        if (list.Sum () > remains) return;
        else if (list.Sum () == remains) {
            ret.Add (new List<int> (list));
            return;
        } else {
            for (int i = current; i < candidates.Length; i++) {
                list.Add (candidates[i]);

                BackTracking (ret, candidates, list, i, remains);

                list.RemoveAt (list.Count - 1);
            }
        }
    }
}