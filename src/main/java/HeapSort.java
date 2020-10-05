public class HeapSort {

    /**
     * Эта штучка пробегает по массиву и переставляет эл-ты, если отец меньше сыновей
     * @param arr - наш массив
     * @param size - размер массива(до какого эл-та будем проверять массив)
     * @param i - с какого эл-та начинать проверять массив
     */
    private static void kucha(int arr[], int size, int i)
    {
        int index = i;

        if (2*i + 1 < size && arr[2*i + 1] > arr[index])
            index = 2*i + 1;

        if (2*i + 2 < size && arr[2*i + 2] > arr[index])
            index = 2*i + 2;

        if (index != i)
        {
            int x = arr[i];
            arr[i]= arr[index];
            arr[index] = x;
            kucha(arr, size, index);
        }
    }

    /**
     * Heap sort
     * @param array - our no sorted array
     * @param size - size of array
     */
    public static void heapsort(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--)
            kucha(array, size, i);


        for (int i= size-1; i>=0; i--)
        {
            int x = array[0];
            array[0]= array[i];
            array[i] = x;
            kucha(array, i, 0);
        }
    }
}
