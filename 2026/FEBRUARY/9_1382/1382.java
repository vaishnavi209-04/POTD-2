//Approach 1-Inorder and binary search tree construction-O(n)
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder=new ArrayList<>();
        find(root,inorder);
        return solve(0,inorder.size()-1,inorder);
    }
    public void find(TreeNode root,List<Integer> inorder)
    {
        if(root==null)
        return;
        find(root.left,inorder);
        inorder.add(root.val);
        find(root.right,inorder);
    }
    public TreeNode solve(int l,int r,List<Integer> list)
    {
        if(l>r)
        return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=solve(l,mid-1,list);
        root.right=solve(mid+1,r,list);
        return root;
    }
}
//Python code
class Solution:
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def inorder(root):
            if not root:
                return 

            inorder(root.left)
            arr.append(root.val)
            inorder(root.right)

        def build(l,r):
            if l>r:
                return None
            mid=(l+r)//2
            root=TreeNode(arr[mid])
            root.left=build(l,mid-1)
            root.right=build(mid+1,r)
            return root
        
        arr=[]
        inorder(root)
        return build(0,len(arr)-1)
        