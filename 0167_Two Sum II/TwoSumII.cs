public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        var ans = new int[2];
        
        int s = 0;
        int e = numbers.Length - 1;
        
        while(s<e){
            var sum = numbers[s] + numbers[e];
            if(sum == target){
                ans[0] = s+1;
                ans[1] = e+1;
                break;
            }else if(sum > target){
                e--;
            }else{
                s++;
            }
        }
        
        return ans;
    }
}