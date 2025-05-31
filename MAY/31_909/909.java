//Approach 1:BFS
//T.C-O(n^2)
//bfs gives us shortest path and here we need min rolls to reach last block so use bfs
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        //board is numbered from 1 to n*n
        int[] minRolls= new int[n * n + 1];
        //mark as unvisited for every block
        Arrays.fill(minRolls, -1);
        //que for bfs
        Queue<Integer> que = new LinkedList<>();
        //we are already on 1st block in start of game so we need 0 rolls to reach there
        minRolls[1] = 0;
        que.offer(1);
        //bfs
        while (!que.isEmpty())
        {
            int x = que.poll();
            //roll dice from 1 to 6
            for (int i = 1; i <= 6 && x + i <= n * n; i++)
            {
                //tentative block
                int t = x + i;
                //subtract 1 because block starts from 1 but array in java starts from 0
                //calc row
                int row = (t - 1) / n;
                //calc column
                int col = (t - 1) % n;
                //our block is a 2-d array so we need to find exact block from row & col calculated
                //even numbered rows start from left to right
                //odd numbered rows start from right to left
                //rows start from bottom 
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                //if the tentative block is -ve then it has a snake or a ladder go to that block
                int y = (v > 0 ? v : t);
                //if we reached the last block then we return curr+1 roll for reaching the lastblock
                if (y == n * n) 
                return minRolls[x] + 1;
                //for not visited block enter the min rolls to reach that block
                if (minRolls[y] == -1) 
                {
                    minRolls[y] = minRolls[x] + 1;
                    que.offer(y);
                }
            }
        }
        return -1;//cannot reach the last block in any way
    }
}