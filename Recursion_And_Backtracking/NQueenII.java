import java.util.*;
 class NQueenII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNQueens(n));
        sc.close();
    
    }
    static  int count ;
    public static int totalNQueens(int n) {
        count = 0 ;
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<n;j++){
                board[i][j]='.';
            }
        }
        solve(board,n,0);
        return count ;
    }
    static void solve(char[][] board , int n , int row){
        if(row == n){
            count++;
        }
        for(int col = 0 ; col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                solve(board,n,row+1);
                board[row][col]='.';
            }
        }
    }
    static boolean isSafe(char[][] board ,int row , int col , int n){
        for(int r = 0 ; r<n;r++){
            if(board[r][col]=='Q') return false ;
        }
        for(int r=row-1,c=col-1;r>=0&&c>=0;r--,c--){
            if(board[r][c]=='Q') return false;
        }
        for(int r = row-1,c=col+1;r>=0&&c<n;r--,c++){
            if(board[r][c]=='Q') return false;
        }
        return true ;
    }
}
