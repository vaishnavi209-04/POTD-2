//Approach 1-Brute Force-O(m * n * min(m,n))
class Solution {

    // store top 3 unique rhombus sums (largest -> smallest)
    int[] arr = {-1,-1,-1};

    // update the top 3 values if the new value qualifies
    void update(int val){

        // ignore duplicates
        if(val == arr[0] || val == arr[1] || val == arr[2]) return;

        // insert val in correct position
        if(val > arr[0]){
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = val;
        } 
        else if(val > arr[1]){
            arr[2] = arr[1];
            arr[1] = val;
        } 
        else if(val > arr[2]){
            arr[2] = val;
        }
    }

    public int[] getBiggestThree(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // maximum possible rhombus size
        int maxSize = Math.min(rows, cols);

        // try all possible rhombus sizes (largest first)
        for(int size=maxSize; size>=1; size--){

            int s = size-1;
            //we are treating i,j as top vertex of our rhombus
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){

                    // size 1 means a single cell
                    if(size == 1){
                        update(grid[i][j]);
                        continue;
                    }

                    // compute boundary coordinates of rhombus
                    int left = j - s;
                    int right = j + s;
                    int bottom = i + 2*s;

                    // skip if rhombus goes outside grid
                    if(left < 0 || right >= cols || bottom >= rows) continue;

                    int sum = 0;

                    // traverse top -> right edge
                    for(int k=1;k<size;k++)
                        sum += grid[i+k][j+k];

                    // traverse right -> bottom edge
                    for(int k=1;k<size;k++)
                        sum += grid[i+s+k][j+s-k];

                    // traverse bottom -> left edge
                    for(int k=1;k<size;k++)
                        sum += grid[bottom-k][j-k];

                    // traverse left -> top edge
                    for(int k=1;k<size;k++)
                        sum += grid[i+s-k][left+k];

                    // update answer if this sum is large enough
                    if(sum > arr[2]) update(sum);
                }
            }
        }

        // remove unused -1 values
        int count = 0;
        for(int v : arr) if(v != -1) count++;

        int[] res = new int[count];
        int idx = 0;

        for(int v : arr)
            if(v != -1) res[idx++] = v;

        return res;
    }
}