/**
 * Найти количество различных элементов массива.
 * Пример: для 1 4 5 1 1 3 ответ 4.
 */

public class UniqueArrayElements {

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 1, 1, 3};
        int uniqueElsNumber = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.println("-----" + array[i]);
            // uniqueElsNumber++;
            boolean isUnique = true;
            for (int j = i + 1; j < array.length; j++) {
                System.out.println("--" + array[j]);
                if (array[i] == array[j]) {
                    isUnique = false;
                }
                if (isUnique) {
                    uniqueElsNumber++;
                }  // TODO: need to check backwards


            }

        }

        System.out.println(uniqueElsNumber);
    }

}
