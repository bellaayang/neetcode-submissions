class Solution {
    boolean[] visited;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
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
                return false;
            }
        }
        return true;
        
    }

    private boolean dfs(int course) {
        if (visited[course]) {
            return false;
        }

        if (map.get(course) == null) {
            return true;
        }

        visited[course] = true;
        List<Integer> list = map.get(course);
        for (int c : list) {
            if (!dfs(c)) {
                return false;
            }
        }
        visited[course] = false;
        map.put(course, new LinkedList<>());
        return true;
    }
}
