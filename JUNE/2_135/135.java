//Approach 1:Double Greedy
//T.C-O(n)
class Solution {
    public int candy(int[] ratings) { 
        int n=ratings.length;
        int[] candy=new int[n];
        //every child at min has 1 candy
        Arrays.fill(candy,1);
        //iterate from left to right and inc according to ratings
        for(int i=1;i<n;i++)
        {
            if(ratings[i-1]<ratings[i])
            {
                candy[i]=candy[i-1]+1;
            }
        }
        //iterate from right to left and inc according to ratings
        int count=0;
        for(int i=n-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i])
            {  //if it is already greater than its neihghbour then no need to increase
                candy[i-1]=Math.max(candy[i]+1,candy[i-1]);
            }
            count+=candy[i-1];
        }
        //above loop starts calculating from n-2 so add n-1th child's candies in the result
        return count+candy[n-1];
    }
}