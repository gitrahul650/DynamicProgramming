package abacktracking;

import java.util.*;

class Point {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class KnightSteps {
    private static boolean isValid(int x, int y, int N, boolean[][] visited) {
        return (x >= 0 && y >= 0 && x < N && y < N && !visited[x][y]);
    }

    private static int minSteps(int N, int[] knightPos, int[] targetPos) {
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        boolean[][] visited = new boolean[N][N];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(knightPos[0] - 1, knightPos[1] - 1, 0));
        visited[knightPos[0] - 1][knightPos[1] - 1] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == targetPos[0] - 1 && current.y == targetPos[1] - 1) {
                return current.dist;
            }

            for (int i = 0; i < 8; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (isValid(newX, newY, N, visited)) {
                    queue.add(new Point(newX, newY, current.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // Target position not reachable
    }

    public static void main(String[] args) {
        int N = 6;
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};

        int steps = minSteps(N, knightPos, targetPos);
        System.out.println("Minimum steps: " + steps);
    }
}
