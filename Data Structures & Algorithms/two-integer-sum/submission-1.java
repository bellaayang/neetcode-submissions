class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                int index = map.get(j);
                result[0] = index;
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
            
        }
        return result;
        
        
    }
}
