package Graph;
import java.util.*;
public class Number_Of_Island {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.print(countIslands(grid, rows, cols));
        sc.close();
    }
  static int countIslands(int mat[][], int m, int n){

      int count = 0;

      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){

              if(mat[i][j] == 1){

                  count++;       // found a new island
                  dfs(mat, i, j, m, n);
              }
          }
      }
      return count;
  }

  static void dfs(int[][] mat, int i, int j, int m, int n){

      if(i < 0 || j < 0 || i >= m || j >= n || mat[i][j] == 0)
          return;

      mat[i][j] = 0;   // mark visited

      dfs(mat, i+1, j, m, n);   // down
      dfs(mat, i-1, j, m, n);   // up
      dfs(mat, i, j+1, m, n);   // right
      dfs(mat, i, j-1, m, n);   // left
  }
}


