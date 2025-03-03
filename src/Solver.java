public class Solver {
    public static void main(String[] args) {
        int[][] game = {
            {1,2,3,4,5,6,7,8,9},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
        };
        Sudoku s = new Sudoku(game);
        System.out.println(s);
        solveSudoku(s);
        System.out.println(s);
    }

    public static boolean isValid(Sudoku board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board.getNum(row, i) == num || board.getNum(i, col) == num) {
                return false;
            }
        }
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getNum(boxRow + i, boxCol + j) == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] findEmptyCell(Sudoku board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getNum(i, j) == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static boolean solveSudoku(Sudoku board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board.insert(row, col, num);

                if (solveSudoku(board)) {
                    return true;
                }

                board.insert(row, col, 0);
            }
        }

        return false;
    }
}
