//Approach 1-O(n)
class Solution {
    public String largestGoodInteger(String num) {
        String[] arr={"999","888","777","666","555","444","333","222","111","000"};
        for(String n:arr)
        {
            if(num.indexOf(n)!=-1)
            return n;
        }
        return "";
    }
}