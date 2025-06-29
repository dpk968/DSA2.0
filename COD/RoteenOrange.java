import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class RoteenOrange {
    static class Pair<T,K>{
        T first;
        K second;
        
        public Pair() {
        }
        
        Pair(T first, K second){
            this.first=first;
            this.second = second;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arrays.sort
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = minTimeToRot(arr,n,m);
        System.out.println(ans);
        sc.close();
        
    }
    public static int minTimeToRot(int[][] arr, int n, int m) {
		// Write your code here.
		boolean vis[][] = new boolean[n][m];
        Queue<Pair<Pair<Integer,Integer>,Integer>> q = new LinkedList<>();
		
		int count1 = 0;
		
		for(int i=0;i<arr.length;i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]==2) {
					q.add(new Pair<>(new Pair<>(i,j),0));
					vis[i][j] = true;
				}
				if(arr[i][j]==1) count1++;			}
		}
		
		int ans = 0;
		
		while(!q.isEmpty()) {
			Pair<Pair<Integer,Integer>,Integer> e =q.poll();
			int i = e.first.first;
			int j = e.first.second;
			int len = e.second;
			
			// up
			if(i-1 >= 0 && !vis[i-1][j] && arr[i-1][j]==1) {
				vis[i-1][j] = true;
				count1--;
				q.add(new Pair<>(new Pair<>(i-1,j),len+1));
			}
			
			// right
			if(j+1 < arr[0].length && !vis[i][j+1] && arr[i][j+1]==1) {
				vis[i][j+1] = true;
				count1--;
				q.add(new Pair<>(new Pair<>(i,j+1),len+1));
			}
			
			// down
			if(i+1 < arr.length && !vis[i+1][j] && arr[i+1][j]==1) {
				vis[i+1][j]= true;
				count1--;
				q.add(new Pair<>(new Pair<>(i+1,j),len+1));
			}
			
			// left
			if(j-1 >= 0 && !vis[i][j-1] && arr[i][j-1]==1) {
				vis[i][j-1] = true;
				count1--;
				q.add(new Pair<>(new Pair<>(i-1,j),len+1));
			}
			
			ans = Math.max(ans,len);
		}

        return count1 == 0 ? ans : -1;

	}
}
