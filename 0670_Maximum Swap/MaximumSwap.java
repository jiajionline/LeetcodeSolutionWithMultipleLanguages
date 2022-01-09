class Solution {
    public int maximumSwap(int num) {
        if(num < 10) return num;
        char[] chars = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];
        
        for(int i=0;i<chars.length;i++)
            bucket[chars[i]-'0'] = i; 
        
        for(int i=0;i<chars.length;i++){
            for(int k=9;k> chars[i] - '0';k--){
                if(bucket[k] > i){
                    char tmp = chars[i];
                    chars[i] = (char)(k + '0');
                    chars[bucket[k]] = tmp;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}