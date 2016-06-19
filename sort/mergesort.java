public void mergeSort(int[] A, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(A, temp, left, middle);
        mergeSort(A, temp, middle + 1, right);
        merge(A, temp, left, middle, right);
    }

    private void merge(int[] A, int[] temp, int left, int middle, int right) {
        int i = left, j = middle + 1;
        for (int k = 0; k < right - left + 1; ++k) {
            if (i <= middle && (j > right || A[i] <= A[j])) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
        }

        for (int k = 0; k < right - left + 1; ++k) {
            A[left + k] = temp[k];
        }
    }
