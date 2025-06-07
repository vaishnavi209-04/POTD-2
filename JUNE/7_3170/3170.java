//Approach 1-Heap
//T.C-O(n log n)
//S.C-O(n)
// we can remove any smallest character in left if we have multiple same smallest character 
//but for lexicographically smallest string we should remove the leftmost smallest of '*'
//so we take a modified priority queue in which first we have minheap according to character i.e arr[0] where we store ch-'a' indices and if they are equal then we have maxheap for those equal characters with their indices in s as arr[1] because leftmost index will be largest in same character indices
//then take an array of n size to mark the indices which have to be removed and don't add them in result string
class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> que=new PriorityQueue<>(
            (a,b)-> 
            {
                if(a[0]==b[0])
                  return Integer.compare(b[1],a[1]);
                return Integer.compare(a[0],b[0]);
            });
        
        int n=s.length();
        int[] removedIdx=new int[n];
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='*')
            {
                int[] arr=que.poll();
                removedIdx[arr[1]]=1;
            }
            else
            que.offer(new int[] {ch-'a',i});//O(log n)
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch!='*' && removedIdx[i]!=1)
            res.append(ch);
        }
        return res.toString();
    }
}