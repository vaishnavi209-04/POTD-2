//Approach 1
class Solution {
    public boolean isPowerOfTwo(int n) {
      if(n>0 && (n&(n-1))==0)
      return true;
      else
      return false;
    }
}
//Approach 2
class Solution {
    public boolean isPowerOfTwo(int n) {
      if(n>0 && (Math.pow(2,30))%n==0)
      return true;
      return false;
    }
}