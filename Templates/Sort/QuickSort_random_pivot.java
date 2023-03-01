class Solution {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int l, int r) {
        if(l >= r) return;
        int v = partition(nums, l, r);
        quickSort(nums, l, v - 1);
        quickSort(nums, v + 1, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int ranIdx = l + new Random().nextInt(r - l + 1);
        swap(nums, r, ranIdx);

        int pivot = nums[r];
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
        }
        int temp = nums[l];
        nums[l] = pivot;
        nums[r] = temp;
        return l;
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}