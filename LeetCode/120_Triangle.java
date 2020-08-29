class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triLength = triangle.size();
        int[][] state = new int[triLength][triLength];
        state[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triLength; i++) {
            for (int j = 0; j < triangle.get(i).size() ; j++) {
                int currentValue = triangle.get(i).get(j);
                if (j == 0) {
                    state[i][j] = state[i - 1][j] + currentValue;
                } else if (j == triangle.get(i).size() - 1) {
                    state[i][j] = state[i - 1][j - 1] + currentValue;
                } else {
                    state[i][j] = Math.min(state[i-1][j-1], state[i-1][j]) + currentValue;
                }
            }
        }
        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triLength - 1).size(); i++) {
            int distance = state[triLength-1][i];
            if (distance < minTotal) {
                minTotal = distance;
            }
        }
        return minTotal;
    }
}
