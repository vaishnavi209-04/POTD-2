//Approach 1-DFS-O(n)
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int curr)
    {
        if(root==null)
        return 0;

        curr=curr*2+root.val;//convert to decimal

        if(isLeaf(root))//leaf node found so return curr decimal number
        return curr;

        return dfs(root.left,curr) + dfs(root.right,curr);
    }
    public boolean isLeaf(TreeNode root)
    {
        return root.left==null && root.right==null;
    }
}