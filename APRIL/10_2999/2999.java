//Approach 1-Maths
//T.C:O((n1-n2) *log(limit))
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startt=String.valueOf(start-1);//we will calculate from 0 to string included 
        String finishh=String.valueOf(finish);
        return solve(finishh,s,limit)-solve(startt,s,limit);

    }
    public long solve(String str,String s,int limit)
    {
        if(str.length()<s.length())//string is less than suffix so no powerful integer exists
        return 0;
        long count=0;
        int n1=str.length();
        int n2=s.length();
        String strSuffix=str.substring(n1-n2);//O(n1)
        for(int i=0;i<n1-n2;i++)//O(n1-n2)
        {
            int digit=str.charAt(i)-'0';
            if(digit<=limit)
            {
            count+=digit*(long)Math.pow(limit+1,n1-i-n2-1);//pow is log (limit)
            }
            //current position digit is greater than limit so the number of digits excluding suffix and from current position will have at most limit options
            else
            {
                count+=(long)Math.pow(limit+1,n1-i-n2);//(0-limit)->limit+1
                return count;
            }
        }
        //if suffix of string is more than or equal to s so it will also include the current suffix s in string
        if(strSuffix.compareTo(s)>=0)
        count++;
        return count;
    }
}