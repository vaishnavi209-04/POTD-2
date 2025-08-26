//Approach 1-O(n)
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area=-1;
        int diagonal=-1;
        for(int[] dim:dimensions)
        {
            int a=dim[0];
            int b=dim[1];
            int currDiag=a*a+b*b;
            if(currDiag>diagonal)
            {
                diagonal=currDiag;
                area=a*b;
            }
            else if(currDiag==diagonal)
            {
                area=Math.max(area,a*b);
            }
        }
        return area;
    }
}