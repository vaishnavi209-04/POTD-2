//Approach 1-Stack + Prefix Sum-O(m*n)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] prefix=new int[m][n];
        for(int j=0;j<n;j++)
        {
            int sum=0;
            for(int i=0;i<m;i++)
            {
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]=='0')
                sum=0;
                prefix[i][j]=sum;
            }
        }
        int res=0;
        for(int[] mat:prefix)
        {
            int curr=largestRectangleArea(mat);
            res=Math.max(res,curr);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int[] left=nsl(heights);
        int[] right=nsr(heights);

        int n=heights.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            int h=heights[i];
            int width=right[i]-left[i]-1;
            int area=h*width;
            res=Math.max(res,area);
        }
        return res;
    }
    public int[] nsl(int[] arr)
    {
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            res[i]=-1;
            else
            res[i]=st.peek();
            st.push(i);
        }
        return res;
    }
    public int[] nsr(int[] arr)
    {
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            res[i]=n;
            else
            res[i]=st.peek();
            st.push(i);
        }
        return res;
    }
}