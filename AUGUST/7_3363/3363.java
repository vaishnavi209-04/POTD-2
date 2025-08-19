//Approach 1-Top Down Approach
class Solution {
    int n;
    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        int child1=child1Collect(fruits);
        int child2=child2Collect(0,n-1,fruits);
        int child3=child3Collect(n-1,0,fruits);
        return child1+child2+child3;
    }
    public int child1Collect(int[][] fruits)
    {
        //for child1 to reach [n-1][n-1] in n-1 steps only way possible is diagonal so he will collect all the diagonal fruits only
        int res=0;
        for(int i=0;i<n;i++)
        {
            res+=fruits[i][i];//diagonal elements i==j
        }
        return res;
    }
    public int child2Collect(int i,int j,int[][] fruits)
    {
        if(i<0 || j>=n || j<0 || i>=n)
        return 0;
        if(i>=j)
        return 0;
        if(i==n-1 && j==n-1)//reached last cell
        return 0;
        //for child2 to reach [n-1][n-1] cell in n-1 steps he should only travel in upper triangle 
        int leftDown=fruits[i][j] + child2Collect(i+1,j-1,fruits);
        int down=fruits[i][j] + child2Collect(i+1,j,fruits);
        int rightDown=fruits[i][j] + child2Collect(i+1,j+1,fruits);

        return Math.max(leftDown,Math.max(down,rightDown));
    }
    public int child3Collect(int i,int j,int[][] fruits)
    {
        if(i<0 || j>=n || j<0 || i>=n)
        return 0;
        if(i<j || i==j)
        return 0;
        if(i==n-1 && j==n-1)//reached last cell
        return 0;
        //for child2 to reach [n-1][n-1] cell in n-1 steps he should only travel in lower triangle 
        int rightUp=fruits[i][j] + child3Collect(i-1,j+1,fruits);
        int right=fruits[i][j] + child3Collect(i,j+1,fruits);
        int rightDown=fruits[i][j] + child3Collect(i+1,j+1,fruits);

        return Math.max(rightUp,Math.max(right,rightDown));
    }
}
//Approach 2-Top Down Approach + Memorisation
//O(n^2)
class Solution {
    int n;
    int[][] dp;
    public int maxCollectedFruits(int[][] fruits) {
        n=fruits.length;
        dp=new int[n][n];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        int child1=child1Collect(fruits);
        int child2=child2Collect(0,n-1,fruits);
        int child3=child3Collect(n-1,0,fruits);
        return child1+child2+child3;
    }
    public int child1Collect(int[][] fruits)
    {
        //for child1 to reach [n-1][n-1] in n-1 steps only way possible is diagonal so he will collect all the diagonal fruits only
        int res=0;
        for(int i=0;i<n;i++)
        {
            res+=fruits[i][i];//diagonal elements i==j
        }
        return res;
    }
    public int child2Collect(int i,int j,int[][] fruits)
    {
        if(i<0 || j>=n || j<0 || i>=n)
        return 0;
        if(i>=j)
        return 0;
        if(i==n-1 && j==n-1)//reached last cell
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        //for child2 to reach [n-1][n-1] cell in n-1 steps he should only travel in upper triangle 
        int leftDown=fruits[i][j] + child2Collect(i+1,j-1,fruits);
        int down=fruits[i][j] + child2Collect(i+1,j,fruits);
        int rightDown=fruits[i][j] + child2Collect(i+1,j+1,fruits);

        return dp[i][j]=Math.max(leftDown,Math.max(down,rightDown));
    }
    public int child3Collect(int i,int j,int[][] fruits)
    {
        if(i<0 || j>=n || j<0 || i>=n)
        return 0;
        if(i<j || i==j)
        return 0;
        if(i==n-1 && j==n-1)//reached last cell
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        //for child2 to reach [n-1][n-1] cell in n-1 steps he should only travel in lower triangle 
        int rightUp=fruits[i][j] + child3Collect(i-1,j+1,fruits);
        int right=fruits[i][j] + child3Collect(i,j+1,fruits);
        int rightDown=fruits[i][j] + child3Collect(i+1,j+1,fruits);

        return dp[i][j]=Math.max(rightUp,Math.max(right,rightDown));
    }
}
//Approach 3-Bottom up Approach -O(n^2)
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int[][] dp=new int[n][n];
        int res=0;
        //for child 1->diagonal elements
        for(int i=0;i<n;i++)
        res+=fruits[i][i];
        //nullify those elements which in valid region but still can't be taken by the child
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i<j && i+j<n-1)//for child 2 by observation
                dp[i][j]=0;
                else if(i>j && i+j<n-1)//for child 3 by observation
                dp[i][j]=0;
                else
                dp[i][j]=fruits[i][j];//can reach here
            }
        }
        //for child 2
        for(int i=1;i<n;i++)
        {
            for(int j=i+1;j<n;j++)//upper triangle-> i<j
            {//movement: /v , |v , \v
               dp[i][j]+=Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],j+1<n?dp[i-1][j+1]:0));
            }
        }
        //for child 3
        for(int j=1;j<n;j++)
        {
            for(int i=j+1;i<n;i++)
            {//movement: /^ , -->,\v
              dp[i][j]+=Math.max(dp[i-1][j-1],Math.max(dp[i][j-1],i+1<n?dp[i+1][j-1]:0));   
            }
        }
        //[n-1][n-1] block is already occupied by child 1 so child 2 and child 3 can at max take fruits of a block less than that by 1 in their path 
        return res+dp[n-2][n-1]+dp[n-1][n-2];
    }
}