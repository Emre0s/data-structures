public class Heap {
    private int heapSize;
    private int dizi[];

    Heap(int capacity) {
        heapSize = 0;
        dizi = new int[capacity];
    }


    public boolean isFull() {
        return heapSize == dizi.length;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }


    public void insert(int element) {
        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }
        dizi[heapSize] = element;
        heapSize++;
        heapifyUp();

    }

    private void heapifyUp() {

        int index = heapSize - 1;

        while (index > 0) {
            if (dizi[(index - 1) / 2] > dizi[index]) {
                int temp = dizi[index];
                dizi[index] = dizi[(index - 1) / 2];
                dizi[(index - 1) / 2] = temp;
                index = (index - 1) / 2;
            } else {
                break;
            }
        }

    }


    public int poll() {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");
        int ans = dizi[0];
        dizi[0] = dizi[heapSize - 1];
        heapSize--;
        heapifyDown();
        return ans;
    }

    private void heapifyDown() {
        int index = 0;
        int left = 2 * index + 1;
        while (left < heapSize) {
            int min = left;
            int right = ++left;
            if (right < heapSize) {
                if (dizi[left] > dizi[right]) {
                    min++;
                }
            }
            if (dizi[index] > dizi[min]) {
                int temp = dizi[min];
                dizi[min] = dizi[index];
                dizi[index] = temp;
            }
            index = min;
            left = 2 * index + 1;
        }
    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println();
    }


}
