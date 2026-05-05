//Approach 1-O(n)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0|| head.next==null)
        return head;
        ListNode temp=head;
        int n=1;//count length of list
        while(temp.next!=null)
        {
            temp=temp.next;
            n++;
        }
        if(k%n==0)//no rotation needed
        {
            return head;
        }
        temp.next=head;//make the list circular
        k=k%n;//in case k>n
        k=n-k;//no of nodes after which we break the list
        ListNode newTail=find(head,k);
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
    public ListNode find(ListNode head,int k)
    {
        int count=1;
        while(head!=null)
        {
            if(count==k)
            return head;
            head=head.next;
            count++;
        }
        return head;
    }
}