//Approach 1-Dijkstra Algorithm-
//T.C-O(mn log mn)
//S.C-O(mn)
class Solution {
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int m=moveTime.length;
        int n=moveTime[0].length;
        int[][] res=new int[m][n];
        for(int[] arr:res)
        Arrays.fill(arr,Integer.MAX_VALUE);//infinite distance to every room
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        res[0][0]=0;//we are starting from first cell so 0 distance
        pq.offer(new int[]{0,0,0});//time,i,j
        while(!pq.isEmpty())
        {
            int[] arr=pq.poll();
            int currTime=arr[0];
            int i=arr[1];
            int j=arr[2];
            if(i==m-1 && j==n-1)//reached the target room
            return currTime;
            for(int[] d:dir)//moving in adjacent directions
            {
               int i_=i+d[0];
               int j_=j+d[1];
               if(i_>=0 && i_<m && j_>=0 && j_<n)
               {
               int wait=Math.max(moveTime[i_][j_]-currTime,0);//if no need for waiting then 0
               int arrTime=currTime+1+wait;
               if(res[i_][j_]>arrTime)//if the curr time is min than the previous calc time for this room
               {
                res[i_][j_]=arrTime;//update
                pq.offer(new int[]{arrTime,i_,j_});//adjacent
               }
               }
            }
        }
        return -1;
    }
}