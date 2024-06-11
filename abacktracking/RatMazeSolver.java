package abacktracking;

import java.util.*;

//class Point {
//    int x, y;
//
//    Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class RatMazeSolver {
    private static boolean bfs(int[][] maze, int N) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] previous = new int[N][N]; // Optional for path reconstruction

        queue.add(new Point(0, 0));
        visited[0][0] = true;

        int[] dx = {0, 1, 0, -1}; // Define possible moves: right, down, left, up
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (x == N - 1 && y == N - 1) {
                // Path found, reconstruct if needed using 'previous' array
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    previous[nx][ny] = i; // Optional for path reconstruction
                }
            }
        }

        return false; // No path found
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int N = maze.length;

        if (bfs(maze, N)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
    }
}
