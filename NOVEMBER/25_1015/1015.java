//Approach 1-Brute Force-O(k)
//Pigeonhole principle -if there are k remainders and the no's are generated more than k times so atleast one rem will repeat itself
//on dividing some no by k we can only get k remainders 
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0)
        return -1;
        if(k==1)
        return 1;

        int rem=0;
        for(int n=1;n<=k;n++)
        {
            rem=(rem*10+1)%k;
            if(rem==0)
            return n;
        }
        return -1;
    }
}