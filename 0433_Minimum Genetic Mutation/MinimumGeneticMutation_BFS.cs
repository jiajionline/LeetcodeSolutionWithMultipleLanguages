public class Solution {
    public int MinMutation(string start, string end, string[] bank) {
        if(start.Equals(end)) return 0;
        
        var charArray = new char[]{'A','C','G','T'};
        
        var bankSet = new HashSet<string>();
        foreach(var gene in bank)
        {
            bankSet.Add(gene);
        }
        
        var queue = new Queue<string>();
        var visited = new HashSet<string>();
        
        queue.Enqueue(start);
        visited.Add(start);
        
        int mutations = 0;
        
        while(queue.Count > 0)
        {
            var size = queue.Count;
            
            while(size-- > 0)
            {
                var s = queue.Dequeue();
                if(s.Equals(end)) return mutations;
                
                visited.Add(s);

                var chars = s.ToCharArray();
                
                for(int i=0;i<chars.Length;i++){
                    var oldChar = chars[i];
                    
                    foreach(var c in charArray){
                        chars[i] = c;
                        var newGene = new String(chars);
                        if(!visited.Contains(newGene) && bankSet.Contains(newGene)){
                            queue.Enqueue(newGene);   
                        }
                    }  
                    
                    chars[i] = oldChar;
                }
            }
            
             mutations++;
        }
        
        return -1;
    }
}