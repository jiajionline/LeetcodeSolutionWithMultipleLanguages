class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
    
    private void heapify(int[] arr, int n, int i) {
        int max = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2; 

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            swap(arr, i, max); 
            heapify(arr, n, max);
        }
    }
    
    private void buildHeap(int[] arr) {
        int n = arr.length;
        // start from the parent of the last element
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void heapSort(int[] arr) {
        buildHeap(arr);
        
        int n = arr.length;       
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}