public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        Queue<Pair> queue = new LinkedList<Pair>();
        //get all the gate
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        if (queue.size() == 0) return;
        //traversal to get distance
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                visited[cur.x][cur.y] = true;
                List<Pair> neighbors = getNeighbors(cur, rooms);
                for (Pair neighbor : neighbors) {
                    if (!visited[neighbor.x][neighbor.y]) {
                        queue.add(neighbor);
                        rooms[neighbor.x][neighbor.y] = distance;
                        visited[neighbor.x][neighbor.y] = true;
                    }
                }
            }
            distance++;
        }
        
    }
    private List<Pair> getNeighbors(Pair cur, int[][] rooms) {
        List<Pair> result = new ArrayList<Pair>();
        int curX = cur.x;
        int curY = cur.y;
        if (curX + 1 < rooms.length && rooms[curX + 1][curY] == 2147483647) {
            result.add(new Pair(curX + 1, curY));
        }
        if (curX - 1 >= 0 && rooms[curX - 1][curY] == 2147483647 ) {
            result.add(new Pair(curX - 1, curY));
        }
        if (curY + 1 < rooms[0].length && rooms[curX][curY + 1] == 2147483647 ) {
            result.add(new Pair(curX, curY + 1));
        }
        if (curY - 1 >= 0 && rooms[curX][curY - 1] == 2147483647 ) {
            result.add(new Pair(curX, curY - 1));
        }
        return result;
    }

    
}
class Pair {
    public int x;
    public int y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
