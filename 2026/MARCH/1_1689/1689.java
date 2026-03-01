class Solution {
    public int minPartitions(String n) {
        
        int res=0;
        int len=n.length();
        for(int i=0;i<len;i++)
        {
            res=Math.max(res,n.charAt(i)-'0');
        }
        return res;
    }
}