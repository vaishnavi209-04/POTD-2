//Approach 1-Sorting -O(n log n)
class Solution {
    public boolean checkStrings(String s1, String s2) {
        List<Character> even1=new ArrayList<>();
        List<Character> odd1=new ArrayList<>();

        for(int i=0;i<s1.length();i++)
        {
            if(i%2==0)
            even1.add(s1.charAt(i));
            else
            odd1.add(s1.charAt(i));
        }

        List<Character> even2=new ArrayList<>();
        List<Character> odd2=new ArrayList<>();

        for(int i=0;i<s2.length();i++)
        {
            if(i%2==0)
            even2.add(s2.charAt(i));
            else
            odd2.add(s2.charAt(i));
        }

        return equals(even1,even2) && equals(odd1,odd2);
    }
    public boolean equals(List<Character> l1,List<Character> l2)
    {
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i=0;i<l1.size();i++)
        {
            if(l1.get(i)!=l2.get(i))
            return false;
        }
        return true;
    }
}