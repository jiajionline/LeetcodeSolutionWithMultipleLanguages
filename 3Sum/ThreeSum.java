
import java.util.*;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
        
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if(nums == null || nums.length <=2) return ret;
		Arrays.sort(nums);
		Set<String> uniqueResultSet = new HashSet<String>();
		
		for(int i=0;i<nums.length-1;i++){
			int a1 = nums[i];
			int left = i+1;
			int right = nums.length - 1;
			
			if(i > 0 && nums[i] == nums[i-1]) continue;
			
			while(left < right){
				if(a1 + nums[left] + nums[right] == 0){
					String s = String.format("%d%d%d", a1, nums[left], nums[right]);
					if(!uniqueResultSet.contains(s)){
						List<Integer> list = new ArrayList<Integer>(3);
						list.add(a1);
						list.add(nums[left]);
						list.add(nums[right]);
						ret.add(list);
						uniqueResultSet.add(s);						
					}
					left++;
					right--;
				}else if(a1 + nums[left] + nums[right] < 0){
					left++;
				}else{
					right--;
				}
			}
		}
		return ret;
    }
}
