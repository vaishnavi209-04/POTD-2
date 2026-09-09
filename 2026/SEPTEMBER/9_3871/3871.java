class Solution {
    public long countCommas(long n) {
        long res=0;
        long p=1000;
        while(p<=n){
            res+=n-p+1;
            p*=1000;
        }
        return res;
    }
}