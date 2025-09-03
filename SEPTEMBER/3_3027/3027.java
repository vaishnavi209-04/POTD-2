//Approach 1-Sorting -O(n^2)
class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        int res=0;
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0])
            return b[1]-a[1];
            return a[0]-b[0];
        });
        for(int i=0;i<n;i++)
        {
            int x1=points[i][0];
            int y1=points[i][1];
            int maxY=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++)
            {
                int x2=points[j][0];
                int y2=points[j][1];
                if(y2>y1)//second point is top right of first instead of bottom right
                continue;
                if(y2>maxY)
                {
                    maxY=y2;
                    res++;
                }
            }
        }
        return res;
    }
}