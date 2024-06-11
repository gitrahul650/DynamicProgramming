package abacktracking;

import java.util.*;

public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        ArrayList<String> path = findPath(maze);

        if (path != null) {
            System.out.println("Path found:");
            for (String cell : path) {
                System.out.print(cell + " ");
            }
        } else {
            System.out.println("No path found.");
        }
    }

    // Helper function to check if a cell is a valid move
    private static boolean isValidMove(int[][] maze, int x, int y, int N, boolean[][] visited) {
        //simplify below logic
        //x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1 && !visited[x][y]
        //simple logic

        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1 && !visited[x][y]);
    }

    // Helper function to perform Depth First Search
    private static boolean dfs(int[][] maze, int x, int y, int N, boolean[][] visited, ArrayList<String> path) {
        if (x == N - 1 && y == N - 1) {
            path.add("(" + x + "," + y + ")");
            return true;
        }

        if (isValidMove(maze, x, y, N, visited)) {
            visited[x][y] = true;
            path.add("(" + x + "," + y + ")");

            if (dfs(maze, x + 1, y, N, visited, path) || dfs(maze, x, y + 1, N, visited, path)) {
                return true;
            }

            path.remove(path.size() - 1); // Backtrack
        }

        return false;
    }

    // Main function to find the path
    public static ArrayList<String> findPath(int[][] maze) {
        int N = maze.length;
        ArrayList<String> path = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        if (dfs(maze, 0, 0, N, visited, path)) {
            return path;
        } else {
            return null;
        }
    }


}
