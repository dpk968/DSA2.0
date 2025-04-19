package recursion;


import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] queen = new char[n][n];

        for (int i = 0; i < queen.length; i++) {
            for (int j = 0; j < queen.length; j++) {
                queen[i][j]='.';
            }
        }

        getNQueen(queen, n, 0);
        sc.close();
    }

    public static void getNQueen(char[][] queen, int n, int col){
        if(col==n){
            printQueen(queen);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isPossible(queen,i,col,n)){
                queen[i][col] = 'Q';
                getNQueen(queen, n, col+1);
                queen[i][col] = '.';
            }
        }
    }

    public static boolean isPossible(char[][] queen, int row, int col, int n){
        int restoreRow = row;
        int restoreCOl = col;

        while (row>=0 && col >= 0) {
            if (queen[row][col]=='Q') {
                return false;
            }
            row--;
            col--;
        }

        row = restoreRow;
        col = restoreCOl;

        while (col>=0) {
            if(queen[row][col]=='Q') return false;
            col--;
        }

        row = restoreRow;
        col = restoreCOl;

        while (row<n && col>=0) {
            if(queen[row][col]=='Q') return false;
            row++;
            col--;
        }


        return true;
    }

    public static void printQueen(char[][] queen){
        for (int i = 0; i < queen.length; i++) {
            for (int j = 0; j < queen.length; j++) {
                System.out.print(queen[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
