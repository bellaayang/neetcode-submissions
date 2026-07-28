class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    boolean[] visited;
    
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtracking(nums);
        return result;
        
    }

     private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
