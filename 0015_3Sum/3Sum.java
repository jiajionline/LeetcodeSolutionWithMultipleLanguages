class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ans = new LinkedList<>(); 
		for (int i = 0; i < num.length-2; i++) {
			if (i > 0 && num[i] == num[i-1]) continue;
			int l = i+1, r = num.length-1, sum = 0 - num[i];
			while (l < r) {
				if (num[l] + num[r] == sum) {
					ans.add(Arrays.asList(num[i], num[l], num[r]));
					while (l < r && num[l] == num[l+1]) l++;
					while (l < r && num[r] == num[r-1]) r--;
					l++; r--;
				} else if (num[l] + num[r] < sum) l++;
				else r--;
			}
		}
		return ans;
	}
}