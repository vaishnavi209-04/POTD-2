//Approach 1-Brute Force-O(n*maxPts)
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] prob=new double[n+1];
        prob[0]=1;//she has score 0 in start
        for(int i=1;i<=n;i++)//calc prob of having score i
        {
            for(int j=1;j<=maxPts;j++)//choose from [1,maxPts]
            {
                //score =j card chosen so prob[j]=1/maxPts
                //prob[i]=prob[i]+prob[i-j](rem)*1/maxPts
                if((i-j)>=0 && (i-j)<k)//if i-j >=k then game will stop so we can't do *1/maxPts
                {
                    prob[i]+=(prob[i-j])/maxPts;
                }
            }
        }
        //we are only calc k to n because game will only stop for score>=k so prob less than k are intermediate prob, they cannot be final prob
        double res=0;
        for(int i=k;i<=n;i++)
        {
            res+=prob[i];
        }
        return res;
    }
}
//Approach 2-Optimal -O(n)
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] prob=new double[n+1];
        prob[0]=1;
        double sum=(k==0)?0:1;//curr prob sum
        for(int i=1;i<=n;i++)
        {
            //prob for *
            prob[i]=sum/maxPts;
            //P[16]=P[16]*P[0](no need)+P[15]*P[1]+....+P[6]*P[10]----->adding last prob(P[15])
            //P[15]=P[15]*P[0](no need)+P[14]*P[1]+.....+P[5]*P[10]
            if(i<k)
            sum+=prob[i];
            //P[18]=P[16]*P[2]+P[15]*P[3]+....+P[8]*P[10]---->in this we are subtracting P[7]*P[10]
            //P[17]=P[16]*P[1]+P[15]*P[2]+....+P[7]*P[10]
            if(i-maxPts>=0 && i-maxPts<k)
            sum-=prob[i-maxPts];
        }
         //we are only calc k to n because game will only stop for score>=k so prob less than k are intermediate prob, they cannot be final prob
        double res=0;
        for(int i=k;i<=n;i++)
        {
            res+=prob[i];
        }
        return res;
    }
}