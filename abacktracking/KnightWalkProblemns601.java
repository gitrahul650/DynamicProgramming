package abacktracking;

import java.util.LinkedList;
import java.util.Queue;

public class KnightWalkProblemns601 {
    // Given a square chessboard of N x N size, the position of Knight and
    //position of a target is given. We need to find out minimum steps a Knight will take to reach
    //the target position
//Example:
//Input: N = 6
//knightPos[] = {4, 5}
//targetPos[] = {1, 1}
//Output: 3
    //Explanation:
//Knight takes 3 step to reach from
//(4, 5) to (1, 1):
//    (4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
//Note:
//1 <= N <= 1000
//1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N

    public static void main(String[] args) {
        int[][] chessBoard = new int[6][6];
//        int[] knightPos = {0, 0};
//        int[] targetPos = {4, 4};
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};
        System.out.println("knightWalkProblem(chessBoard, knightPos, targetPos) = " + knightWalkProblem(chessBoard, knightPos, targetPos));
    }

    private static int knightWalkProblem(int[][] chessBoard, int[] knightPos, int[] targetPos) {
        int N = chessBoard.length;
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(knightPos);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == targetPos[0] && pos[1] == targetPos[1]) {
                return chessBoard[pos[0]][pos[1]];
            }
            for (int i = 0; i < 8; i++) {
                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N && chessBoard[x][y] == 0) {
                    chessBoard[x][y] = chessBoard[pos[0]][pos[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return -1;
    }



}
