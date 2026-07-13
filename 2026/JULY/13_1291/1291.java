//Approach 1:Enumeration-O(1)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();

        String s="123456789";
        for(int len=2;len<=9;len++)
        {
            for(int i=0;i+len<=9;i++)
            {
                int num=Integer.parseInt(s.substring(i,i+len));
                if(num>=low && num<=high)
                list.add(num);
            }
        }
        return list;
    }
}