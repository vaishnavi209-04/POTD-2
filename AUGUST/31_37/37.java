//Approach 1-Backtracking - O(1)
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char d='1';d<='9';d++)
                    {
                        if(isValid(board,i,j,d))
                        {
                        board[i][j]=d;//do
                        //explore
                        if(solve(board))
                        return true;
                        board[i][j]='.';//undo
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int row,int col,char d)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==d)//col validation
            return false;
            if(board[row][i]==d)//row validation
            return false;
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int k=0;k<3;k++)//box validation
        {
           for(int l=0;l<3;l++)
           {
            if(board[sr+k][sc+l]==d)
            return false;
           }
        }
        return true;
    }
}