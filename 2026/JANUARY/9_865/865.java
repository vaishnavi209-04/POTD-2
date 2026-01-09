//same as 1123 problem
//1 pass -O(n)
class Solution {
    class Pair{
    int depth;
    TreeNode node;
    Pair (int depth,TreeNode node)
    {
        this.depth=depth;
        this.node=node;
    }
    }
    Pair solve(TreeNode root)
    {
        if(root==null)
        return new Pair(0,null);
        Pair l=solve(root.left);
        Pair r=solve(root.right);
        if(l.depth==r.depth)
        return new Pair(l.depth+1,root);
        else if(l.depth>r.depth)
        return new Pair(l.depth+1,l.node);
        else
        return new Pair(r.depth+1,r.node);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }
}