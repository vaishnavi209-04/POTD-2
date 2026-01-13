//Approach 1-BS on Answers-O(n log(high-low))
class Solution {
    public double separateSquares(int[][] squares) {
        double res=0.0;
        double low=Double.MAX_VALUE;
        double high=-Double.MAX_VALUE;//y can be negative also so take this directly
        double total=0.0;
        for(int[] sq:squares)
        {
            //it is imp to make l in double before calc area to avoid overflow 
            double l=sq[2];
            low=Math.min(low,sq[1]);//range for bs
            high=Math.max(high,sq[1]+sq[2]);
            total+=l*l;
        }

        while(high-low>1e-5)//0.00001 for precision rather than high>low as ans in 10^-5 is acceptable
        {
            double mid=low + (high-low)/2.0;
            res=mid;
            //we are directly assigning and not doing +1 and -1 because of precision
            if(check(squares,mid,total))
            high=mid;
            else
            low=mid;
        }
        return res;
    }
    public boolean check(int[][] squares,double mid,double total)
    {
        double bottom=0.0;
        for(int[] sq:squares)
        {
            double l=sq[2];
            if((sq[1]+sq[2]) <= mid)//whole square lies below the line
            bottom+= l*l;
            else if(sq[1] < mid)//part of square below the line
            bottom+= l* (mid-sq[1]);
        }

        return bottom>=(total/2.0);//top=bottom=total/2
    }
}