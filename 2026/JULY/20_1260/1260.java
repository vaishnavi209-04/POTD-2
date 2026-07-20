//Approach 1-2d mapping to 1d mapping-O(mn)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int total=m*n;
        k=k%total;

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            List<Integer> row=new ArrayList<>();

            for(int j=0;j<n;j++)
            row.add(0);

            list.add(row);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int oldIdx=i*n+j;
                int newIdx=(oldIdx+k)%total;

                int row=newIdx/n;
                int col=newIdx%n;

                list.get(row).set(col,grid[i][j]);
            }
        }
        return list;
    }
}