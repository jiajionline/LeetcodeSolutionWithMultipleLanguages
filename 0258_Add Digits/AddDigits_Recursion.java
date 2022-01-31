class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int v = 0;
        while(num > 0)
        {
            v += (num % 10);
            num /= 10;
        }
        
        return addDigits(v);
    }
}