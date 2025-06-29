import java.util.Scanner;

public class Rotate2DarrBy1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        rotate(arr,0,0,n,m);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println("final");
        printArr(arr);
        sc.close();
    }

    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    
    public static void rotate(int[][] arr, int r, int c,int rl,int cl) {
        if (r+c>=rl) {
            return;
        }
        int prev = arr[r][cl-1];

        for (int i = cl-1; i > c; i--) {
            arr[r][i] = arr[r][i-1];
        }
        for (int i = r; i < rl-1; i++) {
            arr[i][c] = arr[i+1][c];
        }
        
        for (int i = r; i < cl-1; i++) {
            arr[rl-1][i] = arr[rl-1][i+1];
        }
        
        for(int i=rl-1;i>r+1;i--){
            arr[i][cl-1] = arr[i-1][cl-1];
        }
        arr[r+1][cl-1] = prev;

        rotate(arr,r+1,c+1,rl-1,cl-1);
        
    }
}
