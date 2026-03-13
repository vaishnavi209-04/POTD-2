//Approach 1-BS on Answers-O(w log (wmax * mh^2))
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l=1;
        int max=-1;
        for(int w:workerTimes)
        {
            max=Math.max(max,w);
        }
        long h= (long) max * mountainHeight * (mountainHeight + 1) / 2;
        long res=0;
        while(l<=h)//O(w log h)
        {
            long mid= l + (h-l)/2;
            if(check(mid,workerTimes,mountainHeight))//O(w)
            {
                res=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return res;
    }
    public boolean check(long mid,int[] wt,int mh)
    {
        long h=0;
        for(int w:wt)
        {
            h+=(long) (Math.sqrt(2.0 * mid / w + 0.25) - 0.5);

            if(h>=mh)
            return true;
        }
        return h>=mh;
    }
}