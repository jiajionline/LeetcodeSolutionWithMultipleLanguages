class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            n = convert(n);
            if(!set.add(n)) return false;
        }
        
        return true;
    }
    
    private int convert(int n){
        int v = 0;
        while(n > 0){
            v += (n % 10) * (n % 10);
            n /= 10;
        }
        return v;
    }
}