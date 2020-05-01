 public class Solution {
     public int[] TopKFrequent(int[] nums, int k){
         var ans = new List<int>();
         var arr = new List<int>[nums.Length + 1];
         var dict = new Dictionary<int, int>();
         foreach(var v in nums){
             if(!dict.ContainsKey(v)){
                 dict.Add(v, 0);
             }

             dict[v] += 1;
         }

         foreach(var entry in dict){
             if(arr[entry.Value] == null){
                 arr[entry.Value] = new List<int>();
             }

             arr[entry.Value].Add(entry.Key);
         }

         int i = arr.Length - 1;
         int m = k;
         while(k > 0){
             if(arr[i] != null){
                 ans.AddRange(arr[i]);
                 k -= arr[i].Count;
             }

             i--;
         }

         return ans.GetRange(0, m).ToArray();
     }
 }