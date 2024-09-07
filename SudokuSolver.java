public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
                { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
                { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
        };
        if (solveSudoku(board)) {
            printSudoku(board);
        } else {
            System.out.println("It ia an unsolvable board");
        }

    }

    private static boolean solveSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValidSudoku(board, i, j, k)) {
                            board[i][j] = k;
                            if (solveSudoku(board)) { // Recursive call only if placing 'k' is valid
                                return true;
                            }
                            board[i][j] = 0; // Backtrack if it doesn't lead to a solution
                        }
                    }
                    return false; // If no valid number was found, return false
                }
            }
        }
        return true; // If the board is fully solved, return true
    }

    private static boolean isValidSudoku(int[][] board, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
            if (board[i][col] == number) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == number) {
                return false;
            }
        }
        return true;
    }

    private static void printSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < board.length; j++) {
                System.out.print(" | ");
                System.out.print(board[i][j]);
            }
            System.out.print(" |");
        }
    }
}
