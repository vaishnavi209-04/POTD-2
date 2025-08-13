//Approach 1-O(1)
class Solution {
    public boolean isPowerOfThree(int n) {
      if(n>0 && (Math.pow(3,30))%n==0)
      return true;
      return false;
    }
}