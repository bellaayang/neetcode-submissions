class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    boolean[] onPath; // 当前递归路径上（会撤销）
    boolean[] finished; // 已经彻底处理完、已加入result（不会撤销）
    LinkedList<Integer> result = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        finished = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            map.get(course).add(pre);
        }

        for (int i = 0; i < map.size(); i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;
        for (int c : result) {
            res[idx++] = c;
        }
        return res;
        
    }

    private boolean dfs(int course) {
        if (onPath[course]) {
            return false;
        }

        if (finished[course]) {
            return true;
        }
        onPath[course] = true;
        List<Integer> pres = map.get(course);
        for (int pre : pres) {
            if (!dfs(pre)) {
                return false;
            }
        }
        onPath[course] = false;
        finished[course] = true;
        map.put(course, new LinkedList<>());
        result.add(course);
        return true;
    }
}
