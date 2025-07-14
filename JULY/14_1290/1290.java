//Approach 1-Binary to decimal conversion-O(n)
class Solution {
    public int getDecimalValue(ListNode head) {
        int res=0;
        StringBuilder sb=new StringBuilder();
        while(head!=null)
        {
            sb.append(head.val);
            head=head.next;
        }
        int len=sb.length()-1;//binary power starts from 0 to n-1
        for(int i=0;i<sb.length();i++)
        {
           res+=(sb.charAt(i)-'0') * Math.pow(2,len);
           len--;
        }
        return res;
    }
}