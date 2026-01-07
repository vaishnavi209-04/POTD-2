//Approach1-DFS-O(n)
class Solution {
    public int maxProduct(TreeNode root) {
        long total=dfs(root);
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        long res=0;
        long mod=1_000_000_007;
        while(!que.isEmpty())
        {
            TreeNode x=que.poll();
            
            long curr=(total-x.val)*x.val;//subtree sum is already stored in the respective roots
            res=Math.max(res,curr);

            if(x.left!=null)
            que.offer(x.left);
            if(x.right!=null)
            que.offer(x.right);
        }
        return (int)(res % mod);
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        return 0;

        root.val+= dfs(root.left) + dfs(root.right);//storing subtree sum in the root itself so no need to calculate again and again
        return root.val;
    }
}