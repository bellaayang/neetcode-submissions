class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int topRow = 0;
        int bottomRow = m - 1;
        int row = 0;
        while (topRow <= bottomRow) {
            int midRow = (topRow + bottomRow) / 2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][n - 1]) {
                row = midRow;
                break;
            } else if (target > matrix[midRow][n - 1]) {
                topRow = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                bottomRow = midRow - 1;
            }
        }

        int leftCol = 0;
        int rightCol = n - 1;
        while (leftCol <= rightCol) {
            int midCol = (leftCol + rightCol) / 2;
            if (target == matrix[row][midCol]) {
                return true;
            } else if (target > matrix[row][midCol]) {
                leftCol = midCol + 1;
            } else if (target < matrix[row][midCol]) {
                rightCol = midCol - 1;
            }
        }

        return false;
        
    }
}
