class Solution {
    char[][] arr;
    public String[] createGrid(int m, int n) {
        arr=new char[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(arr[i],'#');
        dfs(0,0,m,n,true);
        String[] res=new String[m];
        for(int i=0;i<m;i++)
            res[i]=new String(arr[i]);
        return res;
    }
    public void dfs(int i,int j,int m,int n,boolean next)
    {
        arr[i][j]='.';
        if(i==m-1 && j==n-1)
            return;
        if(next)
        {
            if(j<n-1)
                dfs(i,j+1,m,n,false);
            else
                dfs(i+1,j,m,n,false);
        }
        else
        {
            if(i<m-1)
                dfs(i+1,j,m,n,true);
            else
                dfs(i,j+1,m,n,true);
            
        }
    }
}