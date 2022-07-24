class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] ans = search(matrix, target);
        if(ans[0] == -1 && ans[1] == -1) {
            return false;
        }

        else {
            return true;
        }
    }

    public static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c;
        if(matrix.length >= 1) {
            c = matrix[0].length - 1;
        }
        else {
            c = matrix.length;
        }


        while(r < matrix.length && c >= 0) {

            if(matrix[r][c] == target) {
                return new int[] {r, c};
            }

            else if(matrix[r][c] < target) {
                r++;
            }

//            if(matrix[r][c] > target) {
//                c--;
//            }
            else {
                c--;
            }

        }

        return new int[] {-1, -1};
    }
}