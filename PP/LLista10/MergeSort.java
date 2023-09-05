public class MergeSort {
	public static void main(String[] args) throws Exception {
		int[] xs = {1,52,42,51,24,12,15,7};
        mergeSortWielo(xs, Runtime.getRuntime().availableProcessors());
		for (Integer i : xs) {
			System.out.println(i);
		}
	}
	public static void mergeSortWielo(int[] xs, Integer n) throws InterruptedException {
        Thread[] threads = new Thread[n];
        int size = xs.length;
        int[][] results = new int[n][size/n];

        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = i*(size/n); j < (i+1)*(size/n); j++, index++) {
                results[i][index] = xs[j];
            }
        }

        for (int i = 0; i < n; i++) {
            final int j = i;
            threads[i] = new Thread(() -> sort_scal(results[j], results.length));
        }
        
        for (int i = 0; i < n; i++) {
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }

        Thread[] threads2 = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads2[i] = new Thread(() -> mergeWielo(results, results.length));
        }

        for (int i = 0; i < n; i++) {
            threads2[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads2[i].join();
        }

        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = i*(size/n); j < (i+1)*(size/n); j++, index++) {
                xs[j] = results[i][index];
            } 
        }
	}

    public synchronized static void mergeWielo(int[][] xxs, int n) {
        if (n < 2)
            return;

        int[] left = xxs[n-2];
        int[] right = xxs[n-1];

        xxs[n-2] = new int[left.length + right.length];

        merge(xxs[n-2], left, right, left.length, right.length);

        mergeWielo(xxs, n-1);
    }

    public synchronized static void sort_scal(int[] xs, int n) {
        if (n < 2)
            return;

        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = xs[i];
        }

        for (int i = mid; i < n; i++) {
            r[i] = xs[i];
        }

        sort_scal(l, mid);
        sort_scal(r, n - mid);

        merge(xs, l, r, mid, n - mid);
    }

    public static void merge(int[] xs, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i< left && j < right) {
            if (l[i] <= r[j]) {
                xs[k++] = l[i++];
            } else {
                xs[k++] = r[j++];
            }
        }
        while (i < left) {
            xs[k++] = l[i++];
        }
        while (j < right) {
            xs[k++] = r[j++];
        }
    }
}
