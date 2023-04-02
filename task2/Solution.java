import java.util.Queue;
import java.util.LinkedList;


class Vec2 {
    int x, y;

    Vec2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Vec2(int position) {
        this.x = (position % 8) + 1;
        this.y = (position / 8) + 1;
    }
}

public class Solution {
    private final int N_SQUARES = 8;
    private final int N_KNIGHT_MOVES = 8;

    // Possible deltas for a knight in each direction (x, y)
    private final int X[] = {2, 1, -1, -2, -2, -1,  1,  2};
    private final int Y[] = {1, 2,  2,  1, -1, -2, -2, -1};

    public static int solution(int src, int dest) {
        Vec2 srcVec = new Vec2(src);
        Vec2 destVec = new Vec2(dest);

        return new Solution().bfs(srcVec, destVec);
    }

    public int bfs(Vec2 start, Vec2 target) {
        Queue<Vec2> queue = new LinkedList<>();
        boolean[][] visited = new boolean[8][8];
        int[][] dist = new int[8][8];

        queue.offer(start);
        dist[start.x - 1][start.y - 1] = 0;
        visited[start.x - 1][start.y - 1] = true;

        while (!queue.isEmpty()) {
            Vec2 curr = queue.poll();

            if (curr.x == target.x && curr.y == target.y) {
                return dist[curr.x - 1][curr.y - 1];
            }

            for (int i = 0; i < N_KNIGHT_MOVES; i++) {
                int x = curr.x + X[i];
                int y = curr.y + Y[i];
                Vec2 next = new Vec2(x, y);

                if (positionInBoundaries(next) && !visited[x - 1][y - 1]) {
                    // Mark as visited
                    visited[x - 1][y - 1] = true;

                    // Update distance from starting position
                    dist[x - 1][y - 1] = dist[curr.x - 1][curr.y - 1] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    private boolean positionInBoundaries(Vec2 point) {
        return point.x >= 1 && point.y >= 1 && 
            point.x <= N_SQUARES && point.y <= N_SQUARES;
    }
}
