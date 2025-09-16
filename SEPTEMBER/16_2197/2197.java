//Approach 1-
//T.C-O(n)
//S.C-O(1)
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int num:nums)
        {
           while(!res.isEmpty())
           { 
            int prev=res.get(res.size()-1);
            int gcd=hcf(num,prev);
            if(gcd<=1)
            break;
            res.remove(res.size()-1);
            num=(int)((long)num*prev/gcd);
           }
           res.add((int)num);
        }
        return res;
    }
    public int hcf(int a,int b)
    {
        if(b==0)
        return a;
        return hcf(b,a%b);
    }
}