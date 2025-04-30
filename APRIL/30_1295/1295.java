//Approach 1:
class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int num:nums)
        {
            StringBuilder sb=new StringBuilder();
            sb.append(num);
            if(sb.length()%2==0)
            res++;
        }
        return res;
    }
}
//Approach 2:
class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int num:nums)
        {
            int count=0;
            while(num>0)
            {
                int rem=num%10;
                count++;
                num/=10;
            }
            if(count%2==0)
            res++;
        }
        return res;
    }
}