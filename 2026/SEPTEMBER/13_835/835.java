//Approach 1:O(n^2+o1*o2)
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> o1=new ArrayList<>();
        List<int[]> o2=new ArrayList<>();

        int n=img1.length;
//store co-ordinates of 1s in img1 and img2 as a pair in o1 and o2
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(img1[i][j]==1)
                o1.add(new int[]{i,j});

                if(img2[i][j]==1)
                o2.add(new int[]{i,j});
            }
        }
//store shift and its count in map which will tell us how many cells overlap from each type of shift
        HashMap<String,Integer> map=new HashMap<>();
        int res=0;
//calculate shift required for each pair and then increment the count of that shift in map
        for(int[] p:o1)
        {
            for(int[] q:o2)
            {
                int dx=p[0]-q[0];
                int dy=p[1]-q[1];

                String key=dx+","+dy;
                int count=map.getOrDefault(key,0)+1;
                map.put(key,count);
                res=Math.max(res,count);
            }
        }
        return res;
    }
}
//Approach 2-Brute Force-O(n^4)
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int res=0;
        //if n=3 then shifts can be -2,-1,0,1,2 with middle row and col as 0 or center
        for(int r=-n+1;r<n;r++)
        {
            for(int c=-n+1;c<n;c++)
            {
                int curr=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        int x=i+r;
                        int y=j+c;
                        if(x>=0 && x<n && y>=0 && y<n && img1[i][j]==1 && img2[x][y]==1)
                        curr++;
                    }
                }
                res=Math.max(res,curr);
            }
        }
        return res;
    }
}