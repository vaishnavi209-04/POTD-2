//Aproach 1-Brute Force-O(n^2)
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count=0;
        int n=differences.length;
        for(int i=lower;i<=upper;i++)
        {
            int sum=i;
            boolean possible=true;
            for(int j=0;j<n;j++)
            {
                sum+=differences[j];
                if(sum<lower || sum > upper)
                {
                    possible=false;
                    break;
                }
            }
            if(possible)
            count++;
        }
        return count;
    }
}
//Aproach 2-Optimal Force-O(n)
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr=0;
        int min=0;
        int max=0;
        for(int diff:differences)
        {
            curr+=diff;
            min=Math.min(min,curr);
            max=Math.max(max,curr);
            if((upper-max)-(lower-min)+1<=0)
            return 0;//no sequence possible
        }
        return (upper-max)-(lower-min)+1;//find the max and min range : for no of elements in a range(a,b)=b-a+1
    }
}