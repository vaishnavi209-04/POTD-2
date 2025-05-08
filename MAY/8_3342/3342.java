 //Approach 1-Dijkstra Algorithm-
//T.C-O(mn log mn)
//S.C-O(mn)
class Solution {
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int m=moveTime.length;
        int n=moveTime[0].length;
        int[][][] res=new int[m][n][2];//last wala yaha se jane ke liye-do options 1 sec ya 2 sec
        for(int[][] arr:res)
        {
        for(int[] a:arr)
        {
        Arrays.fill(a,Integer.MAX_VALUE);//infinite distance to every room
        }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        res[0][0][0]=0;//we are starting from first cell so 0 distance
        pq.offer(new int[]{0,0,0,1});//time,i,j-phli bar me 1 sec ka time lgega
        while(!pq.isEmpty())
        {
            int[] arr=pq.poll();
            int currTime=arr[0];
            int i=arr[1];
            int j=arr[2];
            int nextMoveTime=arr[3];
            if(i==m-1 && j==n-1)//reached the target room
            return currTime;
            if(currTime>res[i][j][nextMoveTime==1?0:1])//index check
            continue;
            for(int[] d:dir)//moving in adjacent directions
            {
               int i_=i+d[0];
               int j_=j+d[1];
               if(i_>=0 && i_<m && j_>=0 && j_<n)
               {
               int wait=Math.max(moveTime[i_][j_]-currTime,0);//if no need for waiting then 0
               int arrTime=currTime+ nextMoveTime +wait;
               int nextNewMoveTime= nextMoveTime==1?2:1;//alternating between two
               if(nextMoveTime ==1)
               {
                if(arrTime<res[i_][j_][0])
                {
                res[i_][j_][0]=arrTime;//update
                pq.offer(new int[]{arrTime,i_,j_,nextNewMoveTime});//adjacent
                }
               }
               else
               {
                  if(arrTime<res[i_][j_][1])
                {
                res[i_][j_][1]=arrTime;//update
                pq.offer(new int[]{arrTime,i_,j_,nextNewMoveTime});//adjacent
                }
               }
               }
            }
        }
        return -1;
    
    }
}