package Test;

public class JavaTest {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double ans = Double.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(i + 1 >= k) {
                ans = Math.max(ans, sum / k);
                sum -= nums[i+1-k];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        JavaTest test = new JavaTest();
        double ans = test.findMaxAverage(new int[]{-1}, 1);
        System.out.println("Answer is " + ans);
    }
}