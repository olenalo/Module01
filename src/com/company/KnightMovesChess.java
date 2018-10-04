/**
 * Ход коня по шахматной доске.
 * Вводится текущее положение коня и клетка в которую пробуют его передвинуть за 1 ход.
 * Программа должна проверить, возможно ли это сделать.
 *
 */

public class KnightMovesChess {

    public static boolean checkIfCanMove(int x, int y, int x1, int y1) {

        // We don't care about the field

        // 4 corner cases (don't care either)
        // [0, 0] --> [2, 1], [1, 2]
        // [7, 0] --> [5, 1], [7, 2]
        // [7, 7] --> [5, 7], [6, 5]
        // [0, 7] --> [2, 7], [0, 1]

        boolean canMove = false;

        if (y1 - y == 2 || y1 - y == -2) {
            if (x1 - x == 1 || x1 - x == -1) {
                canMove = true;
            }

        } else if (y1 - y == 1 || y1 - y == -1) {
            if (x1 - x == 2 || x1 - x == -2) {
                canMove = true;
            }
        }

        return canMove;

    }

    public static void main(String[] args) {
        int a, b, a1, b1;

        // TODO: take from args
        // Success
        a = 4;
        b = 5;
        a1 = 6;
        b1 = 6;

        // Failure
        /*
        a = 4;
        b = 5;
        a1 = 6;
        b1 = 7;
        */

        boolean canMove = checkIfCanMove(a, b, a1, b1);
        String desiredMove = "from {" +  a + ", " + b + "} to {" +  a1 + ", " + b1 + "}";
        if (canMove) {
            System.out.println("The knight can move " + desiredMove);
        } else {
            System.out.println("The knight cannot move " + desiredMove);

        }
    }

}
