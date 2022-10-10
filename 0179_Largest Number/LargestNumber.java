class Solution {
    public String largestNumber(int[] nums) {
    	nums = Arrays.stream(nums).boxed().sorted((a, b) -> {
    		String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s2.compareTo(s1);
    	}). // sort descending
        mapToInt(i -> i).
        toArray();
    	
    	StringBuilder sb = new StringBuilder();
        for(int v : nums) {
            if(v == 0 && sb.length() == 0) continue;
            sb.append(v);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}