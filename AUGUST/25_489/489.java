//Approach 1-O(m*n)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(mat[i][j]);
            }
        }
        int[] res=new int[m*n];
        int k=0;
        for(int i=0;i<map.size();i++)
        {
            List<Integer> list=map.get(i);
            if(i%2==0)
            Collections.reverse(list);
            for(int num:list)
            res[k++]=num;
        }
        return res;
    }
}