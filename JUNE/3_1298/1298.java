//Approach 1:Dfs-O(n)
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candy=0;
        int n=status.length;
        boolean[] vis=new boolean[n];//we will visit each box only once
        boolean[] foundBoxes=new boolean[n];//we found these boxes but don't have keys yet
        for(int box:initialBoxes)
        {
           candy+=dfs(box,status,candies,keys,containedBoxes,vis,foundBoxes);
        }
        return candy;
    }
    public int dfs(int box,int[] status,int[] candies,int[][] keys,int[][] containedBoxes,boolean[] vis,boolean[] foundBoxes)
    {
        if(vis[box])//we have already counted candies of this box
        return 0;
        if(status[box]==0)//we don't have key of this box
        {
            foundBoxes[box]=true;
            return 0;
        }
        vis[box]=true;
        int candy=candies[box];
        //check for the boxes inside curr box
        for(int insideBox:containedBoxes[box])
        {
           candy+=dfs(insideBox,status,candies,keys,containedBoxes,vis,foundBoxes);
        }
        //check for the boxes with keys inside curr box
        for(int key:keys[box])
        {
            status[key]=1;
            if(foundBoxes[key])
            {
                candy+=dfs(key,status,candies,keys,containedBoxes,vis,foundBoxes);
            }
        }
        return candy;
    }
}
//Approach 2:Bfs-O(n)
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candy=0;
        int n=status.length;
        boolean[] vis=new boolean[n];//we will visit each box only once
        boolean[] foundBoxes=new boolean[n];//we found these boxes but don't have keys yet
        Queue<Integer> que=new LinkedList<>();
        for(int box:initialBoxes)
        {
           foundBoxes[box]=true;
           if(status[box]==1)
           {
           vis[box]=true;
           candy+=candies[box];
           que.offer(box);
           }
        }
        while(!que.isEmpty())
        {
            int box=que.poll();
            for(int insideBox:containedBoxes[box])
            {
                foundBoxes[insideBox]=true;
                if(status[insideBox]==1 && !vis[insideBox])
                {
                    que.offer(insideBox);
                    vis[insideBox]=true;
                    candy+=candies[insideBox ];
                }
            }
            for(int key:keys[box])
            {
                status[key]=1;
                if(foundBoxes[key] && !vis[key])
                {
                   que.offer(key);
                   vis[key]=true;
                   candy+=candies[key];
                }
            }
        }
        return candy;
    }
}