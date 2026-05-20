//Approach 1:Brute Force -O(n^3)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<=i;j++)
            {
                for(int k=0;k<=i;k++)
                {
                    if(B[k]==A[j])
                    {
                    count++;
                    break;
                    }
                }
            }
            result[i]=count;
        }
        return result;
    }
}
//Approach 2:Better Solution-O(n^2), space complexity-O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        boolean[] isPresentA=new boolean[n+1];
        boolean[] isPresentB=new boolean[n+1];
        int[] result=new int[n];
        for(int i=0;i<n;i++)
        {
            isPresentA[A[i]]=true;
            isPresentB[B[i]]=true;
            int count=0;
            for(int j=1;j<n+1;j++)//our arrays can't contain 0 and j is pointing to to array elements
            {
                if(isPresentA[j]==true && isPresentB[j]==true)
                count++;
            }
            result[i]=count;
        }
        return result;
    }
}
//Approach 3:Best Approach-O(n) using frequency array
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] freq=new int[n+1];
        int[] result=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(++freq[A[i]]==2)
            count++;
            if(++freq[B[i]]==2)
            count++;
            result[i]=count;
        }
        return result;
    }
}