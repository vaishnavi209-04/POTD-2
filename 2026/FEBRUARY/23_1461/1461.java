//Approach 1-O(n*k)
//No of distinct binary numbers of size k = 2^k
class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++)//O(n)
        {
            if(i+k>n)
            break;
            String str=s.substring(i,i+k);//O(k)
            set.add(str);
        }
        int size=set.size();
        if(size==Math.pow(2,k))
        return true;

        return false;
    }
}