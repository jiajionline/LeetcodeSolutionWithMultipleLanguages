class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        Set<Integer> set = new HashSet();
        
        while(!set.contains(n)) {
            set.add(n);
            int num = 0;
            while(n > 0) {
                num += (n % 10) * (n % 10);
                n /= 10;
            }
            
            if(num == 1) return true;
            n = num;
        }
        
        return false;
    }
}