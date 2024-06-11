package abacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatMazeProblemn501 {
    // Given a maze, NxN matrix.matrix[0][0] (left top corner)is the source and
    //matrix[N-1][N-1](right bottom corner) is destination. There are few cells which are blocked,
    //means rat cannot enter into those cells. Rat can move in direction ( forward,down). A rat has
    //to find a path from source to destination
    //Please fill the code in below method to find a path for rat from source to destination
    //Please use backtracking to find the path.

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}};
        System.out.println("maze = " + Arrays.deepToString(maze));
        System.out.println("solve(maze) = " + solve(maze));
    }

    private static List<List<Integer>> solve(int[][] maze) {
        List<List<Integer>> result = new ArrayList<>();
        solve(maze, result, 0, 0, new ArrayList<>());
        return result;
    }

    private static void solve(int[][] maze, List<List<Integer>> result, int i, int j, List<Integer> list) {
        if (i == maze.length - 1 && j == maze.length - 1) {
            list.add(i);
            list.add(j);
            result.add(list);
        } else {
            if (isSafe(maze, i, j)) {
                list.add(i);
                list.add(j);
                solve(maze, result, i + 1, j, list);
                solve(maze, result, i, j + 1, list);
            }
        }
    }

    private static boolean isSafe(int[][] maze, int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze.length && maze[i][j] == 1;
    }



}
