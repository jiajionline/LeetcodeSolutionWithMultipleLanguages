public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);

        List<String> ans = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    ans.clear();
                    ans.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    ans.add(list2[j]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}