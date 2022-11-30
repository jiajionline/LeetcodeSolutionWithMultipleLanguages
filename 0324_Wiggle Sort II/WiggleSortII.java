class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            copy[i] = nums[i];
        }
        
        Arrays.sort(copy);
        
        int mid = (0 + nums.length-1)/2 - 0;
        int end = nums.length - 1;
        
        for(int i=0;i<nums.length;i++) {
            nums[i] = i % 2 == 0 ? copy[mid--] : copy[end--];
        }
    }
}