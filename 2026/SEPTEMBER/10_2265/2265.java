//Approach 1-O(n^2)
class Solution {
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
    public void solve(TreeNode root)
    {
        int[] arr=new int[2];
        if(root==null)
        return;
        dfs(root,arr);
        if((arr[1]/arr[0])==root.val)
        res++;
        solve(root.left);
        solve(root.right);
    }
    public void dfs(TreeNode root,int[] arr)
    {
        if(root==null)
        return;
        arr[1]+=root.val;
        arr[0]++;
        dfs(root.left,arr);
        dfs(root.right,arr);
    }
}
//Approach 2-O(n)-Optimal 
class Solution {
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    public int[] dfs(TreeNode root)
    {
        if(root==null)
        return new int[]{0,0};
        int[] l=dfs(root.left);
        int[] r=dfs(root.right);
        
        int sum=root.val+l[1]+r[1];
        int count=1+l[0]+r[0];
        if((sum/count)==root.val)
        res++;
        return new int[]{count,sum};
    }
}