//Approach 1-Optimal-O(n)
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
//at most 1 consecutive segment of ones
//only one 1 exists or only 11 or 111 exists
//this rule will break if there is a 0 between two 1
//string can't start with 0 so check if string contains (01)