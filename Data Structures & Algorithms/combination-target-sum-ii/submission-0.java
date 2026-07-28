class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] visited;
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new boolean[candidates.length];
        Arrays.fill(visited, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
        
    }
    private void backtracking (int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && visited[i - 1] == false) {
                continue;
            }

            path.add(candidates[i]);
            visited[i] = true;
            sum += candidates[i];
            backtracking(candidates, target, i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
            sum -= candidates[i];
            
        }
    }
}
