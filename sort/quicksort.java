private void quickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }

        // partition
        int pivot = A[left + (right - left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (i <= j && A[i] < pivot) {
                i++;
            }
            while (i <= j && A[i] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }

        quickSort(A, left, j);
        quickSort(A, i, right);
    }
