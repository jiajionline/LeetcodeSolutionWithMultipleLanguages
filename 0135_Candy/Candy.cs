public class Solution {
    public int Candy(int[] ratings) {
        var list = new int[ratings.Length];
        for(int i=0;i<list.Length;i++) list[i] = 1;
        
        for(int i=1;i<ratings.Length;i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                list[i] = list[i-1] + 1;        
            }
        }
        
        for(int i=ratings.Length -2 ; i>=0;i--)
        {
            if(ratings[i] > ratings[i+1])
                list[i] = Math.Max(list[i], list[i+1]+1);
        }
        
        return list.Sum();
    }
}