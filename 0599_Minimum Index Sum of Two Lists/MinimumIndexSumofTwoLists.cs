public class Solution {
    public string[] FindRestaurant(string[] list1, string[] list2) {
        int minSum = int.MaxValue;
        var list = new List<string>();
        var dict = new Dictionary<string,int>();
        for(int i=0;i<list2.Length;i++)
            dict.Add(list2[i],i);
        
        for(int i=0;i<list1.Length;i++)
        {
            if(dict.ContainsKey(list1[i])) 
            {
                var sum = i + dict[list1[i]];
                if(sum <= minSum)
                {
                    if(sum < minSum) list.Clear();
                    list.Add(list1[i]);
                    minSum = sum;
                }
            }
        }
        
        return list.ToArray();
        
    }
}