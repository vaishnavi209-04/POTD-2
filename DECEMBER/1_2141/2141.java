//Approach 1- Binary Search - O( N log (sum/n))
class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        //total power we can have using all the batteries
        for(int num:batteries)
        sum+=num;
        //min min can be 1 and max can be totalpower/no of computers
        long low=1;
        long high=sum/n;
        while(low<high)
        {
            //check for mid no of minutes
            long mid=high-(high-low)/2;
            long extra=0;
            //check if each battery can give me mid battery or not if not then take whatever it can give
            for(int num:batteries)
            {
                extra+=Math.min(num,mid);
            }
            //for no computers to work mid minutes we need n*mid power and check whether the power we collected from all batteries can give it or not if yes then try to check for more minutes otherwise check for lesser power
            if(extra>=(long)(n*mid))
            low=mid;
            else
            high=mid-1;
        }
        return low;
    }
}