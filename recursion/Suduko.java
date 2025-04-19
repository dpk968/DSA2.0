package recursion;

public class Suduko {
    public static void main(String[] args) {

        char board[][] = { 
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println("Sudoku board before solving:");
        printBoard(board);
        solvehrk(board,0);
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
        System.out.println("Sudoku board after solving:");
        printBoard(board);
    }

    public static boolean solvehrk(char[][] board, int idx) {
        if (idx == 81) {
            printBoard(board);
            return true;
        }
        int r = idx / 9;
        int c = idx % 9;

        if (board[r][c] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (isValid(board, r, c, i)) {
                    board[r][c] = i;
                    if (solvehrk(board, idx + 1)) {
                        return true;
                    }else{
                        board[r][c] = '.';
                    }
                }
            }
            return false;
        }else{
            if (solvehrk(board, idx + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c) {
                return false;
            }
            if (board[row][i] == c) {
                return false;
            }
            if (board[(3 * (row / 3)) + (i / 3)][(3 * (col / 3)) + (i % 3)] == c) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
