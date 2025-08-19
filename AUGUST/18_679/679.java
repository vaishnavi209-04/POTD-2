//Approach 1-Backtracking-O(1) since cards size is fixed =4
class Solution {
    //here real division is occuring which will return (8/3)*3 in decimal instead of 1
    //so we check the diff between val calculated and target if it is very very minute then we return true 
    double eps= 0.00001;
    public boolean judgePoint24(int[] cards) {
        int n=cards.length;
        List<Double> list=new ArrayList<>();
        //convert it into double as division will occur in decimal
        for(int i=0;i<n;i++)
        list.add(1.0 * cards[i]);
        //backtracking
        return solve(list);
    }
    public boolean solve(List<Double> cards)
    {
        //we got the last val
        if(cards.size()==1)
        {
            return Math.abs(cards.get(0)-24)<=eps;//check for precision error
        }
        int n=cards.size();
        for(int i=0;i<n;i++)//choose two numbers first from 4 for performing any operation
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)//can't choose same number both times
                continue;
                List<Double> remain=new ArrayList<>();//store remaining 2 no in this
                for(int k=0;k<n;k++)
                {
                   if(k!=i && k!=j)
                   remain.add(cards.get(k));
                }
                List<Double> possVals=new ArrayList<>();//perform all op on selected i and j no
                Double a=cards.get(i);
                Double b=cards.get(j);
                possVals.add(a+b);
                possVals.add(a-b);
                possVals.add(b-a);
                possVals.add(a*b);
                if(b!=0)//we can't divide by 0
                possVals.add(a/b);
                if(a!=0)
                possVals.add(b/a);
                //now send (left1 no,left2 no,val after i op j)
                for(double val:possVals)
                {
                    remain.add(val);//do
                    if(solve(remain))//explore
                    return true;
                    remain.remove(remain.size()-1);//undo
                }
            }
        }
        return false;
    }
}