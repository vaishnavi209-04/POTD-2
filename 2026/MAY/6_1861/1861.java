//Approach 1-
//T.C=O(m*n) S.C=O(m*n)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char [][] res=new char[n][m];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                res[j][m-1-i]=box[i][j];//90 clockwise=transpose+reverse each row
            }
        }
        //apply gravity
        for(int j=0;j<m;j++)//handle 1 column at a time
        {
            int empty=n-1;//initially assume lowest cell in a col is empty
            for(int i=n-1;i>=0;i--)//then check from bottom to up
            {
                if(res[i][j]=='*')//obstacle block falling stone so below empty cell become invalid
                {
                    empty=i-1;//now stone can only fall up to cell above obstacle
                    continue;
                }
                else if(res[i][j]=='#')
                {
                    res[i][j]='.';//current stone falls so current becomes empty
                    res[empty][j]='#';//move falling stone to empty cell
                    empty--;//now this cell is filled so reduce empty
                }
            }
        }
        return res;
    }
}