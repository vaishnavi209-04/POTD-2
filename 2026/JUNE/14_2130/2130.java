//Approach 1-Reversing 2nd half of the list-O(3*n)
class Solution {
    public int pairSum(ListNode head) {
        //only 2 nodes
        if(head.next.next==null)
        return head.val+head.next.val;
        
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)//O(n)
        {
            fast=fast.next.next;
            slow=slow.next;

        }
        ListNode second=reverse(slow);//O(n)
        int res=-1;
        ListNode first=head;
        while(second!=null)//O(n)
        {
            res=Math.max(res,first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return res;

    }
    public ListNode reverse(ListNode head)//O(n)
    {
        if(head==null || head.next==null)
        return head;
        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}