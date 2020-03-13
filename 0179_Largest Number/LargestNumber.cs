public class Solution {
    public string LargestNumber(int[] nums) {
        Array.Sort(nums, (t1,t2)=>{
            var s1 = t1.ToString() + t2.ToString();
            var s2 = t2.ToString() + t1.ToString();
            return s2.CompareTo(s1);
        });

        var sb = new StringBuilder();
        foreach(var v in nums){
            sb.Append(v);
        }

        return sb[0] == '0' ? "0" : sb.ToString();
    }
}