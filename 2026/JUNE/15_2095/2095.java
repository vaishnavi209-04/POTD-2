//Approach 1-Brute Force-O(2*n)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
        return null;
        ListNode temp=head;
        int n=0;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        int m=n/2-1;
        temp=head;
        while(m-- >0)
        {
          temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
        return null;

        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}