//Approach 1:Greedy-O(num)
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num)
        return "";

        int r=sum%9;
        StringBuilder res=new StringBuilder();
        int nines=sum/9;
        for(int i=0;i<nines;i++)//try to fit as much 9 as we can
        res.append('9');

        if(r>0)//then add the remainder less than 9
        res.append((char)('0'+r));

        int zeroes=num-res.length();
        for(int i=0;i<zeroes;i++)//add zeroes to make up the length upto num
        res.append('0');

        return res.toString();
    }
}