//Approach 1-O(2*n)
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map=new HashMap<>();//these nodes are created
        HashSet<Integer> set=new HashSet<>();
        for(int[] d:descriptions)
        {
            int parent=d[0];
            int child=d[1];
            boolean isLeft= d[2]==1;
            map.putIfAbsent(parent,new TreeNode(parent));
            map.putIfAbsent(child,new TreeNode(child));
            set.add(child);
            if(isLeft)
            map.get(parent).left=map.get(child);
            else
            map.get(parent).right=map.get(child);
        }
        for(int[] d:descriptions)
        {
            if(!set.contains(d[0]))
            return map.get(d[0]);
        }
        return null;
    }
}