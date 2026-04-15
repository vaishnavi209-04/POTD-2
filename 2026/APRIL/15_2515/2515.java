//Approach 1-Traversal-O(n)
class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res=Integer.MAX_VALUE;
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            if(words[i].equals(target))
            {
                int dist=Math.abs(startIndex-i);
                dist=Math.min(dist,n-dist);
                res=Math.min(dist,res);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}