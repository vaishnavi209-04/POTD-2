//Approach 1:LCA-O(n)
class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();//no need of treenode in map as value of each node is unique in this problem
    int dmax;//depth of deepest leaves
    public TreeNode lcaDeepestLeaves(TreeNode root) //O(2*n)
    {
        depth(root,0);
        return lca(root);
    }
    public void depth(TreeNode root,int depth)//O(n)
    {
        if(root==null)
        return ;
        map.put(root.val,depth);
        dmax=Math.max(dmax,depth);
        depth(root.left,depth+1);
        depth(root.right,depth+1);
    }
    public TreeNode lca(TreeNode root)//O(n)
    {
        if(root==null || map.get(root.val)==dmax)
        return root;
        TreeNode left=lca(root.left);
        TreeNode right=lca(root.right);
        if(left!=null && right!=null)//current root is lca 
        return root;
        if(left!=null)//right is null
        return left;
        return right;//leeft is null
    }
}
//Approach 2:One pass-O(n)
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
    public TreeNode lcaDeepestLeaves(TreeNode root) 
    {
        return solve(root).node;

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
   
}