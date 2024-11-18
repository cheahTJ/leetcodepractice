class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < grid.length; i++) {
            for (int t = 0; t < grid[0].length; t++) {
                if (grid[i][t] == '1') {
                    // Do BFS
                    count += 1;
                    s.push(new Pair(i, t));
                    grid[i][t] = '0';
                    while (!s.isEmpty()) {
                        Pair elem = s.pop();

                        if (elem.first + 1 < grid.length && grid[elem.first + 1][elem.second] == '1') {
                            s.push(new Pair(elem.first + 1, elem.second));
                            grid[elem.first + 1][elem.second] = '0';
                        }
                        if (elem.first - 1 >= 0 && grid[elem.first - 1][elem.second] == '1') {
                            s.push(new Pair(elem.first - 1, elem.second));
                            grid[elem.first - 1][elem.second] = '0';
                        }
                        if (elem.second + 1 < grid[0].length && grid[elem.first][elem.second + 1] == '1') {
                            s.push(new Pair(elem.first, elem.second + 1));
                            grid[elem.first][elem.second + 1] = '0';
                        }
                        if (elem.second - 1 >= 0 && grid[elem.first][elem.second - 1] == '1') {
                            s.push(new Pair(elem.first, elem.second - 1));
                            grid[elem.first][elem.second - 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}