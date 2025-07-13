//Approach 1-Sorting & two pointers-O(n log n + m log m)
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        int m=players.length;
        int n=trainers.length;
        while(i<m && j<n)
        {
            if(players[i]<=trainers[j])
            i++;
            j++;
        }
        return i;
    }
}