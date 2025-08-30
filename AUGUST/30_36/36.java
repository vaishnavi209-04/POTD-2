//Approach 1-Brute force-O(m*n)=O(81)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] arr=new boolean[10];
        //check rows
        for(int row=0;row<9;row++)
        {
            Arrays.fill(arr,false);
            for(int col=0;col<9;col++)
            {
                char ch=board[row][col];
                if(ch=='.')
                continue;
                if(arr[ch-'0'])
                return false;
                arr[ch-'0']=true;
            }
        }
        //validate columns
        for(int col=0;col<9;col++)
        {
            Arrays.fill(arr,false);
            for(int row=0;row<9;row++)
            {
                char ch=board[row][col];
                if(ch=='.')
                continue;
                if(arr[ch-'0'])
                return false;
                arr[ch-'0']=true;
            }
        }
        //validate square
        for(int row=0;row<9;row+=3)
        {
            int endRow=row+2;
            for(int col=0;col<9;col+=3)
            {
                int endCol=col+2;
                if(!check(arr,row,endRow,col,endCol,board))
                return false;
            }
        }
        return true;
    }
    public boolean check(boolean[] arr,int sr,int er,int sc,int ec,char[][] board)
    {
        Arrays.fill(arr,false);
        for(int i=sr;i<=er;i++)
        {
            for(int j=sc;j<=ec;j++)
            {
                char ch=board[i][j];
                if(ch=='.')
                continue;
                if(arr[ch-'0'])
                return false;
                arr[ch-'0']=true;
            }
        }
        return true;
    }
}
//Approach 2-1 pass-O(81)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char ch=board[i][j];
                if(ch=='.')
                continue;
                String row=ch +"row"+i;
                String col=ch+"col"+j;
                String box=ch+"row"+"col"+(i/3)+"_"+(j/3);
                if(set.contains(row)|| set.contains(col) || set.contains(box))
                return false;
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}