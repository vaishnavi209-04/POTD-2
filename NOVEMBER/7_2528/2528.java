//Approach 1-Binary Search + Diff Arr + Greedy
//T.C= O(n + n log C)= O(n log C) c is the range of binary search
//S.C= O(n) due to diff array
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n=stations.length;
        //at lowest power of any station can be min of all stations assuming its neighbours have 0 power
        long low=Integer.MAX_VALUE;
        //at highest power of any station can be sum of all the powers of stations if range is over all the stations and the power of extra stations added
        long high=0;
        high+=k;
        //diff array where diff[l]+=x and diff[r+1]-=x
        long[] diff=new long[n];
        for(int i=0;i<n;i++)
        {
            low=Math.min(low,stations[i]);
            high+=stations[i];
            diff[(int)Math.max(0,i-r)]+=stations[i];
            if(i+r+1<n)
            diff[i+r+1]-=stations[i];
        }
        
        long res=0;
        while(low<=high)
        {
            long mid=low +(high-low)/2;
            if(check(mid,stations,r,k,n,diff))
            {
                res=mid;
                low=mid+1;//go higher to find maximum 
            }
            else
            {
                high=mid-1;
            }
        }
        return res;
    }
    public boolean check(long mid,int[] stations,int r,int k,int n,long[] diff)
    {
        long[] temp=Arrays.copyOf(diff,n);//temp array for curr diff array
        long cumSum=0;
        for(int i=0;i<n;i++)
        {
            cumSum+=temp[i];//cumulative sum of all powers till now
            if(cumSum<mid)// we have to maintain at least mid power for all station
            {
                long need=mid-cumSum;//we need this much power more 
                if(need>k)//if we can't add the needed power
                return false;
                k-=need;//remove the added stations from extra stations
                cumSum+=need;//add the extra stations' power to cumulative sum

                if(i+ 2L*r+1<n)//modify the effect of extra station to the right side max range possible according to diff array
                temp[(int)(i+ 2L*r+1)]-=need;
            }
        }
        return true;
    }
}