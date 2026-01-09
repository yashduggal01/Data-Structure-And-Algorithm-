import java.util.List;
import java.util.Scanner;
import java.util.*;
public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> result = solveNQueens(n);
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        sc.close();
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ; j<n;j++){
                board[i][j]='.';
            }
        }
        ArrayList<List<String>> res = new ArrayList<>();
        solve(board,res,n,0);
        return res;
    }
    static void solve(char[][] board , List<List<String>> res , int n,int row){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0 ; i<n;i++){
                String curr = "";
                for(int j = 0 ;j<n;j++){
                    curr+=board[i][j];
                }
                temp.add(curr);
            }
            res.add(temp);
        }
        for(int col =0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col]='Q';
                solve(board,res,n,row+1);
                board[row][col]='.';
            }
        }
    }
    static boolean isSafe(char[][] board ,int row , int col,int n ){
        for(int i = 0 ; i<n;i++){
            if(board[i][col]=='Q') return false;
        }
        for(int i =row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i = row -1 ,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}
