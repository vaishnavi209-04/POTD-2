//Approach 1:Store only first,prev,last
//T.C=O(n) S.C=O(1)
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode prev=head;
        ListNode curr=head.next;
        int index=1;
        int first=-1;
        int last=-1;
    
        int max=-1;
        int min=Integer.MAX_VALUE;
        while(curr.next!=null)
        {
            boolean critical =((curr.val<prev.val && curr.val<curr.next.val)|| (curr.val>prev.val && curr.val>curr.next.val));
            
            if(critical)
            {
                if(first==-1)
                {
                    first=index;
                }
                else
                {
                    min=Math.min(min,index-last);
                    max=index-first;
                }
                last=index;
            }

            index++;
            prev=curr;
            curr=curr.next;
            
        }
        
        if(max==-1)
        return new int[]{-1,-1};

        return new int[]{min,max};
        
    }
}