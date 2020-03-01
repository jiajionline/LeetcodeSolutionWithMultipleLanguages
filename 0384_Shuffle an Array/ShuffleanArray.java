class Solution {
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int[] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        original = nums.clone();
    }

    public int[] reset() {
        int[] array = original.clone();
        return array;
    }

    public int[] shuffle() {
        int[] array = original.clone();
        for (int i = 0; i < array.length; i++) {
            swapAt(array,i, randRange(i, array.length));
        }
        return array;
    }
}
