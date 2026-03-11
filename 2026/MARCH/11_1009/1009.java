//Approach 1-O(log n)
class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
        return 1;

        int res = 0;
        int i = 0;

        while(n > 0)
        {
            int d = n % 2;
            if(d == 0)
            res += Math.pow(2,i);
            i++;
            n/=2;
        }
        return res;
    }
}