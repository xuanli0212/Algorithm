private void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            int minIndex = i;
            for (int j = i; j < A.length; ++j) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }

            swap(A, minIndex, i);
        }
    }

    private void insertionSort(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            int j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                swap(A, j - 1, j);
                j--;
            }
        }
    }

    private void bubbleSort(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            for (int j = 0; j < A.length - 1 - i; ++j) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
    }
