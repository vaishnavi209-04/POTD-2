//Approach 1-binary representation
//T.C-O(q* 32)- at max size of powers can be 32 as max size bits in binary representation can be 32 bits
class Solution {
    int mod=1_000_000_007;
    //here powers can be made as n's binary representation
    //eg: 12- 1100- 2^3+2^2+2^1+2^0={8,4}- sorted form-{4,8}
    public int[] productQueries(int n, int[][] queries) {
        int len=queries.length;
        int[] res=new int[len];
        List<Long> powers=new ArrayList<>();
        for(int i=0;i<32;i++)
        {
            if((n & (1<<i))!=0)//returns true if bits is 1 in binary representation of n
            powers.add((long)Math.pow(2,i));
        }
        int c=0;
        for(int[] query:queries)//O(q)
        {
            int start=query[0];
            int end=query[1];
            long prod=1;
            for(int i=start;i<=end;i++)//O(32)
            {
              prod=(prod * powers.get(i))% mod;
            }
            res[c++]=(int)prod ;
        }
        return res;
    }
}