class Solution {
    public void rotate(int[][] matrix) {
         
        // Swapping along the diagonal of the matrix first
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Only swap those which are after the diagonal entries
                if (i != j && j > i) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }


        // Swapping the content inwards
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < Math.floor(matrix[i].length / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;            
            }
        }

        // Used for checking
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         System.out.println(matrix[i][j]);
        //     }
        // }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6}, {7,8,9}};
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        s1.rotate(matrix2);
    }
}