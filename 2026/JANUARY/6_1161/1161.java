//Approach 1-BFS-O(n)
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        int max=Integer.MIN_VALUE;
        int level=0;
        int res=0;
        while(!que.isEmpty())
        {
            int n=que.size();
            level++;
            int sum=0;
            while(n-- >0)
            {
            TreeNode x=que.poll();
            sum+=x.val;
            
            if(x.left!=null)
            que.offer(x.left);
            if(x.right!=null)
            que.offer(x.right);
            }
            if(sum>max)
            {
                max=sum;
                res=level;
            }
        }
        return res;
    }
}