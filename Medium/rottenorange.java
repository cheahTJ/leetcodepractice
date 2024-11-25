class Pair {
    int one;
    int two;

    public Pair(int one, int two) {
        this.one = one;
        this.two = two;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        // First find all the number of rotten oranges and the count of all the good oranges
        // Use BFS idea and process level by level for al the rotten oranges
        // Check at the end if the number of good ornage is 0
        int rounds = 0;
        int goodOrange = 0;
        Queue<Pair> bad = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    bad.add(new Pair(i, j));  
                } else if (grid[i][j] == 1) {
                    goodOrange += 1;  
                }
            }
        }

        if (goodOrange == 0) {
            return 0;
        }

        int[] directions = {0, 1, 0, -1, 0};  
        while (!bad.isEmpty() && goodOrange > 0) {
            // This is the part to process at each level
            int size = bad.size();  

            for (int i = 0; i < size; i++) {
                Pair rotten = bad.remove();
                int x = rotten.one;
                int y = rotten.two;

                // Try to rot the adjacent good oranges
                for (int d = 0; d < 4; d++) {
                    int nx = x + directions[d];
                    int ny = y + directions[d + 1];

                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;  
                        goodOrange -= 1;   
                        bad.add(new Pair(nx, ny)); 
                    }
                }
            }
            rounds += 1;
        }
        return goodOrange == 0 ? rounds : -1;
    }
}
