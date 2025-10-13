//Approach 1-O(n * k log k)
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();

        list.add(words[0]);
        char[] arr = words[0].toCharArray();
        Arrays.sort(arr);
        String prev = new String(arr);

        int n = words.length;

        for (int i = 1; i < n; i++) {
            arr = words[i].toCharArray();
            String word = new String(arr);
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (sorted.equals(prev))
                continue;
            else {
                list.add(word);
                prev = sorted;
            }
        }
        return list;
    }
}