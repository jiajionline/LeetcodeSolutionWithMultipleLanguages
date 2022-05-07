class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i= arr.length-1;i>0;i--) {
            while(arr[i] != i+1) {
                int idx = findMax(arr, 0, i);
                if(idx != 0) { 
                    flip(arr, 0, idx);
                    ans.add(idx + 1);  
                }
                
                flip(arr, 0, i);
                ans.add(i+1);
            }
        }
        
        return ans;
    }
    
    private int findMax(int[] arr, int l , int r) {
        int idx = -1;
        int max = -1;
        for(int i=l;i<=r;i++) {
            if(arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
    private void flip(int[] arr, int l , int r) {
        while(l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }
}