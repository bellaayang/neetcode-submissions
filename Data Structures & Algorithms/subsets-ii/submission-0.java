class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);

        backtracking(nums, 0);
        return result;
        
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new LinkedList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
