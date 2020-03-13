import java.util.Collections;
import java.util.List;

public class HeapSort<E extends Comparable<E>> implements SortingTechnique {
    private List<E> arr;
    int n;

    public HeapSort(List<E> arr) {
        this.arr = arr;
        n = arr.size();
    }

    @Override
    public void sort() {
        heapSort();
    }

    @Override
    public void print() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).toString() + " ");
        }
        System.out.println();
    }

    private void heapify(int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        int largest = index;  // the index of the largest element in the heap
        if (l < n && arr.get(l).compareTo(arr.get(largest)) > 0)
            largest = (l);

        if (r < n && arr.get(r).compareTo(arr.get(largest)) > 0) {
            largest = (r);
        }
        if (largest != index) {
            Collections.swap(arr, index, largest);
            heapify(largest);
        }
    }

    private void build_max_heap() { // O(n)
        for (int i = n / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapSort() {
        build_max_heap();
        //print(); // if you want to see the heap tree
        int max = n ;
        for(int i = 0 ; i < max ; i++) {
            Collections.swap(arr, 0 , n-1 );
            n-- ;
            heapify(0);
        }

    }

}
