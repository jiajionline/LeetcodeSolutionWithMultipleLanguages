
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int currentCount = 0;
		for(int v : nums){
			if(v == 1){
				currentCount++;
				max = Math.max(currentCount, max);
			}else{
				currentCount = 0;
			}
		}
		
		return max;
	}
}
