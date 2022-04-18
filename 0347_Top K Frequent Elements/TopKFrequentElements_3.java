class Solution {
    private int[] unique;
    private Map<Integer, Integer> count;
    
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int n = count.size();
        unique = new int[n]; 
        
        int i = 0;
        for (int num: count.keySet()) {
            unique[i++] = num;
        }

        quickselect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    public int partition(int start, int end, int pivotIndex) {
        int pivot = count.get(unique[pivotIndex]);
        int left = start;
        for(int i = start; i < end;i++) {
            if (count.get(unique[i]) <= pivot) {
                swap(left++, i);
            }
        }
        
        swap(left, end);

        return left;
    }
    
    public void quickselect(int left, int right, int k) {
        if (left == right) return;
        
        int pivotIndex = right; 
        pivotIndex = partition(left, right, pivotIndex);

        if (k == pivotIndex) {
            return;    
        } else if (k < pivotIndex) {
            quickselect(left, pivotIndex - 1, k);     
        } else {
            quickselect(pivotIndex + 1, right, k);  
        }
    }
    
    
    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}