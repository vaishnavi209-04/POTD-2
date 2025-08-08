//Approach 1-Brute Force-TLE
class Solution {
    int[][] taken={{100,0},{75,25},{50,50},{25,75}};
    public double soupServings(int n) {
        return solve(n,n);
    }
    public double solve(double A,double B)
    {
        //final probabilities
        if(A<=0 && B<=0)
        return 0.5;//given in ques- half the probability that both soups are used up in the same turn

        if(A<=0)
        return 1.0;//A is used up before B-100% confirmed so 1

        if(B<=0)
        return 0.0;//A is used up before B-0% prob so 0

        double prob=0.0;
        for(int[] take:taken)
        {
            int A_take=take[0];
            int B_take=take[1];
            prob+=solve(A-A_take,B-B_take);
        }
        return 0.25*prob;
    }
}
//Approach 2-Recursion + Memorization-TLE
class Solution {
    int[][] taken={{100,0},{75,25},{50,50},{25,75}};
    double[][] memo;
    public double soupServings(int n) {
        memo=new double[n+1][n+1];
        for(double[] arr:memo)
        {
            Arrays.fill(arr,-1);//n^2
        }
        return solve(n,n);
    }
    public double solve(int A,int B)
    {
        //final probabilities
        if(A<=0 && B<=0)
        return 0.5;//given in ques- half the probability that both soups are used up in the same turn

        if(A<=0)
        return 1.0;//A is used up before B-100% confirmed so 1

        if(B<=0)
        return 0.0;//A is used up before B-0% prob so 0

        if(memo[A][B]!=-1)
        return memo[A][B];

        double prob=0.0;
        for(int[] take:taken)
        {
            int A_take=take[0];
            int B_take=take[1];
            prob+=solve(A-A_take,B-B_take);
        }
        return memo[A][B]=0.25*prob;
    }
}
//Approach 3-Recursion + Memorization + ques trick
//O(n^2)
class Solution {
    int[][] taken={{100,0},{75,25},{50,50},{25,75}};
    double[][] memo;
    public double soupServings(int n) {
        //There is no operation that pours 0 mL from A and 100 mL from B.->so at larger n prob of a being empty will get 1
        if(n>=5000)
        return 1;

        memo=new double[n+1][n+1];
        for(double[] arr:memo)
        {
            Arrays.fill(arr,-1);//n^2
        }
        return solve(n,n);
    }
    public double solve(int A,int B)
    {
        //final probabilities
        if(A<=0 && B<=0)
        return 0.5;//given in ques- half the probability that both soups are used up in the same turn

        if(A<=0)
        return 1.0;//A is used up before B-100% confirmed so 1

        if(B<=0)
        return 0.0;//A is used up before B-0% prob so 0

        if(memo[A][B]!=-1)
        return memo[A][B];

        double prob=0.0;
        for(int[] take:taken)
        {
            int A_take=take[0];
            int B_take=take[1];
            prob+=solve(A-A_take,B-B_take);
        }
        return memo[A][B]=0.25*prob;
    }
}