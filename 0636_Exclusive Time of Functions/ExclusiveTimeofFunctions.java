class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            
            int funcId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timeScheduled = Integer.parseInt(parts[2]);
            
            if(type.equals("start")) {
                if(stack.size() > 0) {
                    ans[stack.peek()] += timeScheduled - prevTime;
                }
                stack.push(funcId);
                prevTime = timeScheduled;
            }else {
                ans[stack.pop()] += timeScheduled - prevTime + 1;
                // timeScheduled is the end of current interval, belong to current interval.  it need +1
                prevTime = timeScheduled + 1;
            }
        }
        return ans;
    }
}