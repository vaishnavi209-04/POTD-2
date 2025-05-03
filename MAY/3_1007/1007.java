//Approach 1:O(n)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] arr=new int[7];//for dice count
        for(int num:tops)//counting in tops
        arr[num]++;
        for(int num:bottoms)//counting in bottom
        arr[num]++;
        int num=0;
        int max=0;
        for(int i=1;i<=6;i++)
        {
            if(arr[i]>max)//finding dice number with max count
            {
              num=i;
              max=arr[i];
            }
        }
        int n=tops.length;
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++)//checking for tops having same row
        {
            if(tops[i]==num) continue;
            if(bottoms[i]==num)
            count1++;
            else
            {
                count1=-1;
                break;
            }
        }
         for(int i=0;i<n;i++)//checking for bottoms having same row
        {
            if(bottoms[i]==num) continue;
            if(tops[i]==num)
            count2++;
            else
            {
                count2=-1;
                break;
            }
        }
        if(count1==-1 && count2==-1) 
        return -1;
        if(count1==-1)
        return count2;
        if(count2==-1)
        return count1;
        return Math.min(count1,count2);
    }
}
//Approach 2:O(n)
//max count wlae dice number ki zarurat thi hi nhi kyuki 0th position me to do hi choice hai ya to tops[0] rhega ya bottom [0] aur phir row ko same krna hai to uski bhi do hi choice 
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count=solve(tops,bottoms,tops[0]);//tops[0] element ko same kr rhe hai
        if(count!=-1)
        return count;
        return solve(tops,bottoms,bottoms[0]);//bottoms[0] element ko same kr rhe hai
    }
    public int solve(int[] tops,int[] bottoms,int target)
    {
        int n=tops.length;
        int flipTop=0,flipBottom=0;
        for(int i=0;i<n;i++)
        {
            if(tops[i]!=target && bottoms[i]!=target)//ye position same ho hi nhi skti
            return -1;
            else if(tops[i]!=target)
            flipTop++;
            else if(bottoms[i]!=target)
            flipBottom++;
        }
        return Math.min(flipTop,flipBottom);
    }
}