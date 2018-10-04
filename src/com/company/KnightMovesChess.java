/**
 * Ход коня по шахматной доске.
 * Вводится текущее положение коня и клетка в которую пробуют его передвинуть за 1 ход.
 * Программа должна проверить, возможно ли это сделать.
 */

public class KnightMovesChess {

    public static void main(String[] args) {
        int[][] chessField = new int[8][8];

        int[] currentPosition = new int[2];  // TODO: take from args
        int[] desiredPosition = new int[2];  // TODO: take from args

        // 4 corner cases
        // [0, 0] --> [2, 1], [1, 2]
        // [7, 0] --> [5, 1], [7, 2]
        // [7, 7] --> [5, 7], [6, 5]
        // [0, 7] --> [2, 7], [0, 1]



    }

}
