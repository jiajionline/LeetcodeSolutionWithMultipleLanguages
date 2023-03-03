class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    
    private void mergeSort(int[] nums , int l , int r) {
        if(l >= r) return;
        int mid = (r-l)/2 + l;
        mergeSort(nums, l , mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }
    
    private void merge(int[] nums, int l, int mid, int r){
        int[] left = new int[mid - l + 1];
        System.arraycopy(nums,  l , left, 0, left.length);
        int[] right = new int[r - mid];
        System.arraycopy(nums, mid+1, right, 0, right.length);
        
        int p1 = 0, p2 = 0;
        while(p1 < left.length || p2 < right.length){
            if(p1 < left.length && p2 < right.length) {
                if(left[p1] <= right[p2]){
                    nums[l + p1+p2] = left[p1++];
                }else{
                    nums[l + p1+p2] = right[p2++];
                }
            }else if(p1 < left.length){
                nums[l+p1+p2] = left[p1++];
            }else{
                nums[l+p1+p2] = right[p2++];
            }
        }
    }
}