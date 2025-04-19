package recursion;

import java.util.Scanner;

public class RatInMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        isPossible(maze,0,0,vis,"");

        sc.close();
    }

    public static void isPossible(int[][] maze, int row, int col, boolean[][] vis, String path){
        if(row==maze.length-1 && col == maze.length-1){
            System.out.println(path);
            return;
        }

        // Down
        if (row+1<maze.length && !vis[row+1][col] && maze[row+1][col]==1) {
            vis[row+1][col] = true;
            isPossible(maze, row+1, col, vis, path+"D");
            vis[row+1][col] = false;
        }

        //Left
        if (col-1>=0 && !vis[col-1][row] && maze[col-1][row]==1) {
            vis[row][col-1] = true;
            isPossible(maze, row, col-1, vis, path+"L");
            vis[row][col-1] = false;
        }

        // right
        if(col+1<maze.length && !vis[row][col+1] && maze[row][col+1]==1){
            vis[row][col+1] = true;
            isPossible(maze, row, col+1, vis, path+"R");
            vis[row][col+1] = false;
        }

        //UP
        if (row-1>=0 && !vis[row-1][col] && maze[row-1][col]==1) {
            vis[row-1][col] = true;
            isPossible(maze, row-1, col, vis, path+"U");
            vis[row-1][col] = false;
        }
    }
}
