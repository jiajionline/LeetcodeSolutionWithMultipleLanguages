public class Solution {
    public IList<IList<int>> SubsetsWithDup(int[] nums) {
        Array.Sort(nums);
        var ans = new List<IList<int>>();
        DFS(nums, 0, new List<int>(), ans, new HashSet<string>());
        return ans;
    }
    
    private void DFS(int[] nums, int index, IList<int> list, IList<IList<int>> ans, HashSet<string> set)
    {
        var result = String.Join(", ", list.ToArray());
        if(!set.Contains(result))  
        {
            ans.Add(new List<int>(list));
            set.Add(result);
        }
        
        for(int i=index;i<nums.Length;i++)
        {
            list.Add(nums[i]);
            DFS(nums, i+1, list, ans, set);
            list.RemoveAt(list.Count-1);
        }
    }
}