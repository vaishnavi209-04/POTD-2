//Approach 1-Memoization + Recursion + Sorting + flattening the factory array
//T.C & S.C= O(robot.size() * positions.size())
class Solution {
    Long[][] dp;
    long INF=(long)1e15;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));
        List<Integer> positions=new ArrayList<>();
        //instead of using limit duplicate each factory limit times and take them each time as separate for easy calculation
        for(int[] f:factory)
        {
            while(f[1]-- >0)
            positions.add(f[0]);
        }
        dp=new Long[robot.size()][positions.size()];

        return solve(0,0,robot,positions);
    }
    public long solve(int i,int j,List<Integer> robot,List<Integer> pos)
    {
        if(i>=robot.size())
        return 0;

        if(j>=pos.size())
        return INF;

        if(dp[i][j]!=null)
        return dp[i][j];

        long next=solve(i+1,j+1,robot,pos);//assign next robot to next factory
        long take=INF;

        if(next!=INF)//because we are adding it into something so check first 
        take=Math.abs(robot.get(i)-pos.get(j)) + next;

        long skip=solve(i,j+1,robot,pos);//skip current factory assign to any other factory

        return dp[i][j]=Math.min(take,skip);
    }
}
//Approach 2-Memoization + Recursion + Sorting + not flattening the factory array
//T.C= O(robot.size() * positions.size() *limit)
//S.C= O(robot.size() * positions.size() )
class Solution {
    Long[][] dp;
    long INF=(long)1e15;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));//sort by position

        dp=new Long[robot.size()][factory.length];

        return solve(0,0,robot,factory);
    }
    public long solve(int i,int j,List<Integer> robot,int[][] factory)
    {
        if(i>=robot.size())//no robot left => got result
        return 0;

        if(j>=factory.length)//no factory left => dead end
        return INF;

        if(dp[i][j]!=null)
        return dp[i][j];

        long skip=solve(i,j+1,robot,factory);//skip current factory assign to any other factory
        long take=INF;
        long cost=0;
        //assign 0 to k robots from i to factory j and calc min total distance for i+k robots
        for(int k=1;k<=factory[j][1] && i+k-1 < robot.size();k++)
        {
            cost+=Math.abs(robot.get(i+k-1)-factory[j][0]);//distance of curr robot 
            long next=solve(i+k,j+1,robot,factory);//assign next robot from i+k to next factory

            if(next!=INF)//because we are adding it into something so check first 
            take=Math.min(take,cost + next);//check for min distance after each limit increment upto k
        }

        return dp[i][j]=Math.min(take,skip);
    }
}
//Approach 3-Bottom up + Sorting + not flattening the factory array
//T.C= O(robot.size() * positions.size() *limit)
//S.C= O(robot.size() * positions.size() )
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));//sort by position
        long INF=(long)1e15;

        int n=robot.size();
        int m=factory.length;

        long[][] dp=new long[n+1][m+1];
        for(long[] arr:dp)
        {
            Arrays.fill(arr,INF);
        }
        //base case: dp[i][j]=cost to assign i robots using j factories
        for(int j=0;j<m;j++)
        {
            dp[0][j]=0;//cost to assign 0 robots using j factories
        }

        for(int j=1;j<=m;j++)
        {
            for(int i=1;i<=n;i++)
            {
               dp[i][j]=dp[i][j-1];//skip
               long cost=0;
               for(int k=1; k<=factory[j-1][1] && k<=i;k++)
               {
                // We are assigning k robots to current factory (j-1)

                // These robots are:
                // robot[i-k], robot[i-k+1], ..., robot[i-1]

                // Add the next robot (moving backward)
                cost+=Math.abs(robot.get(i-k)-factory[j-1][0]);

                if(dp[i-k][j-1]!=INF)// Remaining robots (first i-k) handled by previous factories
                dp[i][j]=Math.min(dp[i][j],cost + dp[i-k][j-1]);
               }
            }
        }

        return dp[n][m];
    }
}