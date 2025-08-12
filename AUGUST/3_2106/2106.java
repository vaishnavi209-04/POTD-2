//Approach 1-Prefix sum + binary search- O(n + k log n)
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n=fruits.length;
        int[] sum=new int[n];
        int[] indices=new int[n];
        for(int i=0;i<n;i++)//O(n)
        {
           indices[i]=fruits[i][0];
           sum[i]=(i>0?sum[i-1]:0)+fruits[i][1];
        }
        int max=0;
        for(int d=0;d<=k/2;d++)//O(k)
        {
            //case 1-move d steps to left and then remaining in right
            int remain=k-2*d;//d for going in left then d for returning those steps 
            int i=startPos-d;
            int j=startPos+ remain;
            int left=lowerBound(indices,i);//finding indices
            int right=upperBound(indices,j)-1;//O(log n)
            if(left<=right)
            {
                int tempMax=sum[right]-(left>0?sum[left-1]:0);//counting fruits at left index too
                max=Math.max(max,tempMax);
            }
            //case 2-move d steps to right and then remaining in left
            remain=k-2*d;//d for going in left then d for returning those steps 
            i=startPos-remain;
            j=startPos + d;
            left=lowerBound(indices,i);//finding indices
            right=upperBound(indices,j)-1;
            if(left<=right)
            {
                int tempMax=sum[right]-(left>0?sum[left-1]:0);//counting fruits at left index too
                max=Math.max(max,tempMax);
            }
        }
        return max;
    }
    public int lowerBound(int[] arr,int target)
    {
        int left=0;
        int right=arr.length;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<target)
            left=mid+1;
            else
            right=mid;
        }
        return left;
    }
    public int upperBound(int[] arr,int target)
    {
        int left=0;
        int right=arr.length;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<=target)
            left=mid+1;
            else
            right=mid;
        }
        return left;
    }
}