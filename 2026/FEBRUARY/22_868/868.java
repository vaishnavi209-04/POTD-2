//Approach 1-O(log n)
class Solution {
    public int binaryGap(int n) {
        if(n<=2)//0,01,10
        return 0;

        String num=Integer.toBinaryString(n);//O(log n)
        int l=num.length();
        int res=0;
        int dist=1;//start from curr idx so count it too therefore 1
        //O(log n)
        for(int i=1;i<l;i++)//start from 1 because binary representation will never start from 0 except for 0
        {
            char digit=num.charAt(i);
            if(digit=='1')
            {
                res=Math.max(res,dist);
                dist=1;
            }
            else
            {
                dist++;
            }
        }
        return res;
    }
}