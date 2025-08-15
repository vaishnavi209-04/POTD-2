//Approach 1-
class Solution {
    public boolean isPowerOfFour(int n) {
      if(n>0 && (Math.pow(4,30))%n==0 && n%3==1)
      return true;
      return false;
    }
}