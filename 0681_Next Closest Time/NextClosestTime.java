class Solution {
    int diff = Integer.MAX_VALUE;
    String ans = "";
    
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for(char c : time.toCharArray()) {
            if(Character.isDigit(c)) set.add(c-'0');
        }
        if (set.size() == 1) return time;
        
        List<Integer> digits = new ArrayList<>(set);
        String[] strs = time.split(":");
        int minutes = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);

        dfs(digits, "", 0, minutes);

        return ans;
    }

    private void dfs(List<Integer> digits, String cur, int index, int target) {
        if (index == 4) {
            String hour = cur.substring(0, 2);
            String min = cur.substring(2, 4);
            int totalMins = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
            if (totalMins == target) return;
            int d = totalMins - target > 0 ? totalMins - target : 1440 + totalMins - target;
            if (d < diff) {
                diff = d;
                ans = hour + ":" + min;
            }
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (index == 0 && digits.get(i) > 2) continue;
            if (index == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23) continue;
            if (index == 2 && digits.get(i) > 5) continue;
            if (index == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59) continue;
            dfs(digits, cur + digits.get(i), index + 1, target);
        }
    }
}