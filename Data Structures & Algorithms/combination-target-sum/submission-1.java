class Solution {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         Arrays.sort(nums);
        backtracking(nums, target, 0, 0);
        return result;
        
    }
    private void backtracking (int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
            
            
        }
      

    }
}
