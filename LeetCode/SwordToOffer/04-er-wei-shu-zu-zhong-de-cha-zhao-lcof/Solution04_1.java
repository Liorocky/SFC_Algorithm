class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int index = -1;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] < target) {
                index++;
                continue;
            } else if (matrix[0][j] == target) {
                return true;
            } else {
                index = j - 1 < 0 ? j : j - 1;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][index] == target) {
                return true;
            }
        }

        return false;
    }
}