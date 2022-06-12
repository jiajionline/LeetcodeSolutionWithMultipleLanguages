class Solution {
    private int ans;
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        ans = n;
        Arrays.sort(tasks);
        dfs(tasks, new int[n], n-1, 0, sessionTime);;
        return ans;
        
    }
    
    private void dfs(int[] tasks, int[] sessions, int taskId, int sessionCount, int maxSessionTime) {
        if(sessionCount > ans) return; //already more than global value, just return
        if(taskId < 0) {
            ans = Math.min(ans, sessionCount);
            return;
        }
        
        for(int i=0; i < sessionCount; i++) {
            if(sessions[i] + tasks[taskId] <= maxSessionTime) {
                sessions[i] += tasks[taskId];
                dfs(tasks, sessions, taskId - 1, sessionCount, maxSessionTime);
                sessions[i] -= tasks[taskId];
            }
        }
        
        sessions[sessionCount] += tasks[taskId]; //put taskId into a new session
        dfs(tasks, sessions, taskId - 1, sessionCount+1, maxSessionTime);
        sessions[sessionCount] -= tasks[taskId];
    }
}