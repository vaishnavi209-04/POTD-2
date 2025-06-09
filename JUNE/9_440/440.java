//Approach 1
//T.C-O(log n)^2
//at max we can go in O(d)- depth = number of digits in n
//S.C-O(log n)-System stack
class Solution {
    public int findKthNumber(int n, int k) {
        int curr=1;
        k-=1;//including 1 so find k-1 numbers more
        while(k>0)
        {
            int cnt=count(curr,curr+1,n);
            if(cnt<=k)//next number se generate kro
            {
                curr++;
                k-=cnt;//sare number curr se generate hue unka count minus krdo
            }
            else//isi number me hai kth no to aur deep jao aur curr ko minus krdo k se
            {
                curr*=10;
                k-=1;//curr ka minus krdo count
            }
        }
        return curr;
    }
    public int count(long curr,long next,long n)
    {
        int cnt=0;
        while(curr<=n)
        {
            //if next>n so at max it can be next of n
            cnt+=Math.min(next,n+1)-curr;//n+1-n=1 counting n
            curr*=10;//next number se generate kro
            next*=10;
        }
        return cnt;
    }
}