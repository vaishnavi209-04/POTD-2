//Approach 1-Sorting
//T.C-O(d log d)- d is digits in n
class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target=sorted(n);
        //2^29 ~ 10^9 (constraint)
        for(int i=0;i<=29;i++)//check for all powers of 2
        {
            String check=sorted((int)Math.pow(2,i));
            if(check.equals(target))
            return true;
        }
        return false;
    }
    public String sorted(int n)
    {
        char[] arr=Integer.toString(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}