class Safe {
    static boolean check(int[] array) {
        int n = 0;
        int m = 1;

        if (array[n] < array[m]) {
            while (array[n] < array[m] && (1 <= (array[m] - array[n]) && 3 >= (array[m] - array[n]))) {
                if (m == array.length - 1) {
                    return true;
                }
                n++;
                m++;
            }

        } else if (array[n] > array[m]) {
            while (array[n] > array[m] && ((1 <= array[n] - array[m]) && 3 >= (array[n] - array[m]))) {
                if (m == array.length - 1) {
                    return true;
                }
                n++;
                m++;
            }
        }
        return false;
    }
}
