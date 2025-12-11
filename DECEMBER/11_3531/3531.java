//Approach 1-
//T.C=O(n)  S.C=O(n)
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] xmin=new int[n+1];
        int[] xmax=new int[n+1];
        int[] ymin=new int[n+1];
        int[] ymax=new int[n+1];
        Arrays.fill(xmin,n+1);
        Arrays.fill(ymin,n+1);

        for(int[] arr:buildings)
        {
            int x=arr[0];
            int y=arr[1];
            xmin[y]=Math.min(xmin[y],x);
            xmax[y]=Math.max(xmax[y],x);
            ymin[x]=Math.min(ymin[x],y);
            ymax[x]=Math.max(ymax[x],y);
        }
        int res=0;
        for(int[] arr:buildings)
        {
            int x=arr[0];
            int y=arr[1];
            if((x>xmin[y] && x<xmax[y]) && (y>ymin[x] && y<ymax[x]))
            res++;
        }
        return res;
    }
} 