class Solution {
    private int lowerBound(String[] products, String word) {
        int l = 0, r = products.length;
        while (l < r) {
            int mid = (r-l)/2 + l;
            if (products[mid].compareTo(word) >= 0)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    
    private int upperBound(String[] products, String word) {
        int l = 0, r = products.length;
        while (l < r) {
            int mid = (r-l)/2 + l;
            if (products[mid].compareTo(word) > 0)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            List<List<String>> ans = new ArrayList<>();
            String prefix = "";
            for (char c : searchWord.toCharArray()) {
                ans.add(new ArrayList<>());
                prefix += c;
                int start = lowerBound(products, prefix);
                int end = upperBound(products, prefix + "~");
                for (int i = start; i < Math.min(start + 3, end); i++) {
                    ans.get(ans.size() - 1).add(products[i]);
                }
            }
            return ans;
        }
}