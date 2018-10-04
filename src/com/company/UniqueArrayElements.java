/**
 * Найти количество различных элементов массива.
 * Пример: для 1 4 5 1 1 3 ответ 4.
 */

public class UniqueArrayElements {

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 1, 1, 3, 8, 8};
        // int[] uniqueElements = new int[array.length];
        int uniqueElsNumber = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    isUnique = false;
                    // break;
                }
            }
            if (isUnique) {
                uniqueElsNumber++;
                // uniqueElements[i] = array[i];
            }

        }

        System.out.println("Number of unique elements is " + uniqueElsNumber);
    }

}
