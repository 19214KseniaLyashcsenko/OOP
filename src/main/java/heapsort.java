public class heapsort {
    public heapsort() {
    }

    public static void heapSort(int[] a, int size) {
        int n;
        int x;
        for(n = size; n > 0; --n) {
            for(x = n / 2 - 1; x >= 0; --x) {
                int k = 1;
                int i = x;

                while(k == 1) {
                    if (2 * i + 1 < n - 1) {
                        if (a[i] <= a[2 * i + 1] && a[i] <= a[2 * i + 2]) {
                            break;
                        }

                        if (a[2 * i + 1] <= a[2 * i + 2]) {
                            x = 2 * i + 1;
                        } else {
                            x = 2 * i + 2;
                        }

                        int s = a[i];
                        a[i] = a[x];
                        a[x] = s;
                        i = x;
                    } else {
                        if (2 * i + 1 > n - 1 || a[i] <= a[2 * i + 1]) {
                            break;
                        }

                        x = a[i];
                        a[i] = a[2 * i + 1];
                        a[2 * i + 1] = x;
                        i = 2 * i + 1;
                    }
                }
            }

            x = a[0];
            a[0] = a[n - 1];
            a[n - 1] = x;
        }

        for(n = 0; n < size / 2; ++n) {
            x = a[n];
            a[n] = a[size - n - 1];
            a[size - n - 1] = x;
        }

    }
}

