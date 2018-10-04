/**
 * Ход коня по шахматной доске.
 * Вводится текущее положение коня и клетка в которую пробуют его передвинуть за 1 ход.
 * Программа должна проверить, возможно ли это сделать.
 *
 * Reference:
 *     http://megachess.net/School_textbook_lesson3
 *
 */

public class KnightMovesChess {

    public static boolean checkIfCanMove(int x, int y, int x1, int y1) {

        // We don't care about the field (except for the entry check)

        // 4 corner cases, indexes start from 0 (don't care either) TODO although we might want to check
        // [0, 0] --> [2, 1], [1, 2]
        // [7, 0] --> [5, 1], [7, 2]
        // [7, 7] --> [5, 7], [6, 5]
        // [0, 7] --> [2, 7], [0, 1]

        boolean canMove = false;

        if (x1 < 8 && y1 < 8) {

            if (y1 - y == 2 || y1 - y == -2) {
                if (x1 - x == 1 || x1 - x == -1) {
                    canMove = true;
                }

            } else if (y1 - y == 1 || y1 - y == -1) {
                if (x1 - x == 2 || x1 - x == -2) {
                    canMove = true;
                }
            }

        } else {
            System.out.println("There is no such position as {" + x1 + ", " + y1 + "}");
        }

        return canMove;

    }

    public static void main(String[] args) {
        // Success
        int x = 4, y = 5, x1 = 6, y1 = 6;

        // Failure
        // int x = 4, y = 5, x1 = 6, y1 = 7;
        // int x = 4, y = 5, x1 = 6, y1 = 8;

        boolean canMove = checkIfCanMove(x, y, x1, y1);
        String desiredMove = "from {" +  x + ", " + y + "} to {" +  x1 + ", " + y1 + "}";
        if (canMove) {
            System.out.println("The knight can move " + desiredMove);
        } else {
            System.out.println("The knight cannot move " + desiredMove);

        }
    }

}
