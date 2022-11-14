class Solution {
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strArr, new CustomComparator());
        
        if(strArr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strArr) sb.append(s);
        
        return sb.toString();
    }
    
    private class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b){
            return (b+a).compareTo(a+b);
        }
    }
}