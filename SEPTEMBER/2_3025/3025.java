//Approach 1-Brute Force - O(n^3)
class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=0;j<n;j++)
            {
                if(i==j)
                continue;
                int x2=points[j][0];
                int y2=points[j][1];
                if(x1<=x2 && y1>=y2)
                {
                    boolean pointInBetween=false;
                    for(int k=0;k<n;k++)
                    {
                        if(k==i || k==j)
                        continue;
                        int x3=points[k][0];
                        int y3=points[k][1];

                        if(x3>=x1 && x3<=x2 && y3>=y2 && y3<=y1)
                        {
                            pointInBetween=true;
                            break;
                        }
                    }
                    if(!pointInBetween)
                    res++;
                }
            }
        }
        return res;
    }
}
//Approach 2-Sorting -O(n^2)
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
            int maxY=-1;
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