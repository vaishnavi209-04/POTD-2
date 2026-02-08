//Approach 1-O(n*n)-dfs
class Solution {
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res=true;
        if(root==null)
        return res;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root)
    {
        if(root==null)
        return ;
        int lh=height(root.left);//height of left subtree
        int rh=height(root.right);//height of right subtree
        if(Math.abs(lh-rh)>=2)
        {
            res=false;
            return;
        }
        //move ahead
        dfs(root.left);
        dfs(root.right);
    }
    public int height(TreeNode root)
    {
        if(root==null)
        return 0;
        //height 
        return 1+Math.max(height(root.left),height(root.right));
    }
}
//Approach 2-O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        return 0;//-1 krege to height bhi minus ho jayegi
        int lh=dfs(root.left);
        if(lh==-1)
        return -1;
        int rh=dfs(root.right);
        if(rh==-1)
        return -1;
        if(Math.abs(lh-rh)>1)
        return -1;
        return 1+Math.max(lh,rh);
    }
}