public class Solution {
    public int[] Intersect (int[] nums1, int[] nums2) {
        Array.Sort (nums1);
        Array.Sort (nums2);

        int p1 = 0;
        int p2 = 0;

        List<int> list = new List<int> ();

        while (p1 < nums1.Count () && p2 < nums2.Count ()) {
            if (nums1[p1] == nums2[p2]) {
                list.Add (nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        return list.ToArray ();
    }

}