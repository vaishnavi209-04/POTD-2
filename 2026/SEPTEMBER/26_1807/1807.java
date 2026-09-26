//Approach 1:O(m+n)
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();

        for(List<String> list:knowledge)
        {
            map.put(list.get(0),list.get(1));
        }

        StringBuilder sb=new StringBuilder();
        String key="";
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                key="";
                i++;
                while(s.charAt(i)!=')')
                {
                    key+=s.charAt(i);
                    i++;
                }
                if(!map.containsKey(key))
                sb.append('?');
                else
                {
                    String val=map.get(key);
                    sb.append(val);
                }
                continue;
            }
            sb.append(ch);

        }
        return sb.toString();
    }
}