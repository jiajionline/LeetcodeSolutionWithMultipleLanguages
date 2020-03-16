public class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int ans = 0;
        while(true){
            int sum = 0;
            while(num > 0){
                sum += (num % 10);
                num /= 10;
            }
 
            if(sum < 10){
                ans = sum;
                break;
            }
            num = sum;
        }
 
        return ans;
    }
 }
 