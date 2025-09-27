//Approach 1-Brute Force-O(n^3)
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double res=0.0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    res=Math.max(res,area(points[i],points[j],points[k]));
                }
            }
        }
        return res;
    }
    public double area(int[] x,int[] y,int[] z)
    {
        return 0.5*Math.abs(x[0]*(y[1]-z[1]) +y[0]*(z[1]-x[1]) +z[0]*(x[1]-y[1]));
    }
}