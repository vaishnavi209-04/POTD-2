//Approach 1-Dijkstra Alogrithm-O(mn log mn)
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int m=grid.size();
        int n=grid.get(0).size();
        
        int[][] arr=new int[m][n];//stores health lost to reach cell i,j
        for(int[] num:arr)
        {
            Arrays.fill(num,-1);//not ye finalized state
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid.get(0).get(0),0,0});
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();//remove best cell(cell with least health loss)
            int val=curr[0];
            int u=curr[1];
            int v=curr[2];
            //we already finalized so no need to finalize again because in dijkstra we are removing best first so we won't get any better afterwards
            if(arr[u][v]>=0)
            continue;
            //health lost for curr cell
            arr[u][v]=val;
            //explore in all 4 directions
            for(int[] d:dir)
            {
                int u_=u+d[0];
                int v_=v+d[1];
                //invalid cell
                if(u_<0 || v_<0 || u_>=m || v_>=n)
                continue;
                //already finalzied
                if(arr[u_][v_]>=0)
                continue;
                //add new cell state
                pq.offer(new int[]{val+grid.get(u_).get(v_),u_,v_});

            }
        }
        //if health lost in cell m-1,n-1 is less than total health then return true true
        return arr[m-1][n-1] < health;

    }
}
//Approach 2-0-1 BFS-O(mn)
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int m=grid.size();
        int n=grid.get(0).size();
        
        int[][] arr=new int[m][n];
        for(int[] num:arr)
        {
            Arrays.fill(num,Integer.MAX_VALUE);//not ye finalized state
        }
        //add cells with 0 health loss at front and with 1 health loss at end
        Deque<int[]> dq=new ArrayDeque<>();

        dq.offerFirst(new int[]{0,0});
        arr[0][0]=grid.get(0).get(0);

        while(!dq.isEmpty())
        {
            int[] curr=dq.pollFirst();//remove best cell(cell with least health loss and nearest neighbour)

            int val=curr[0];
            int u=curr[0];
            int v=curr[1];
            
            if(u==m-1 && v==n-1)
            return true;
            //explore in all 4 directions
            for(int[] d:dir)
            {
                int u_=u+d[0];
                int v_=v+d[1];
                //invalid cell
                if(u_<0 || v_<0 || u_>=m || v_>=n)
                continue;
                
                //add new cell state
                int dist=arr[u][v]+grid.get(u_).get(v_);
                //we will lose more health from this cell than we have so invalid path
                if(dist>=health)
                continue;

                if(dist<arr[u_][v_])//found new shortest path
                {
                  arr[u_][v_]=dist;
                  if(grid.get(u_).get(v_)==0)
                  dq.addFirst(new int[]{u_,v_});
                  else
                  dq.addLast(new int[]{u_,v_});

                }

            }
        }
         
    return false;

    }
}