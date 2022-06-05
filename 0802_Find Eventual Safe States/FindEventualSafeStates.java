
class Solution {
	enum State { SAFE,UNSAFE }

	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> ans = new ArrayList<>(graph.length);
		State[] states = new State[graph.length];
		for (int node = 0; node < graph.length; node++) {
			if (dfs(graph, node, states)) {
				ans.add(node);
			}
		}
		return ans;
	}

	private boolean dfs(int[][] graph, int node, State[] states) {
		if (states[node] != null) {
			return states[node] == State.SAFE;
		}

		states[node] = State.UNSAFE;

		for (int next : graph[node]) {
			if (!dfs(graph, next, states)) return false;
		}

		states[node] = State.SAFE;
		return true;
	}
}