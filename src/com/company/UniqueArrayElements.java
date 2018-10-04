/**
 * Найти количество различных элементов массива.
 * Пример: для 1 4 5 1 1 3 ответ 4;
 * {1, 4, 5, 1, 1, 3, 8, 8, 9, 9} -> returns 6.
 */

public class UniqueArrayElements {

    public static boolean checkIfCounted(int element, int[] array) {
        boolean isPresent = false;
        for (int el: array) {
            if (element == el) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 1, 1, 3};  // {1, 4, 5, 1, 1, 3, 8, 8, 9, 9}
        int[] uniqueElements = new int[array.length];
        int uniqueElsNumber = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique || !checkIfCounted(array[i], uniqueElements)) {
                uniqueElsNumber++;
                uniqueElements[i] = array[i];
            }
        }

        System.out.println("Number of unique elements is " + uniqueElsNumber);
    }

}
