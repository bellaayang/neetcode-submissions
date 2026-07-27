class Solution {
     List<Integer> paths = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
   
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
        
    }

    private void backtracking (int[] nums, int startIndex) {
        res.add(new LinkedList<>(paths));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            paths.add(nums[i]);
            backtracking(nums, i + 1);
            paths.remove(paths.size() - 1);
            
        }
    }

}
