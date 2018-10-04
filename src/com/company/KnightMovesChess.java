/**
 * Ход коня по шахматной доске.
 * Вводится текущее положение коня и клетка в которую пробуют его передвинуть за 1 ход.
 * Программа должна проверить, возможно ли это сделать.
 *
 */

public class KnightMovesChess {

    public static boolean checkIfCanMove(int a, int b, int a1, int b1) {
        // 4 corner cases
        // [0, 0] --> [2, 1], [1, 2]
        // [7, 0] --> [5, 1], [7, 2]
        // [7, 7] --> [5, 7], [6, 5]
        // [0, 7] --> [2, 7], [0, 1]

        boolean canMove = false;

        // TODO put the logic here

        return canMove;

    }

    public static void main(String[] args) {
        int a, b, a1, b1;

        // TODO: take from args
        a = 2;
        b = 4;
        a1 = 6;
        b1 = 7;

        boolean canMove = checkIfCanMove(a, b, a1, b1);
        String desiredMove = "from {" +  a + ", " + b + "} to {" +  a1 + ", " + b1 + "}";
        if (canMove) {
            System.out.println("The knight can move " + desiredMove);
        } else {
            System.out.println("The knight cannot move" + desiredMove);

        }
    }

}
