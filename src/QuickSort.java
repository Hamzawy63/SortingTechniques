public class QuickSort<E extends Comparable<E>> implements SortingTechnique{
    /**
     * Implementation of quick sort using the middle  element as the pivot
     */
    private E[] arr;
    private int n;

    QuickSort(E[] arr) {
        this.arr = arr;
        this.n = arr.length;
    }
    public void sort() {
        quickSort(0, n - 1);
    }
    private void quickSort(int l, int r) {
        if (l < r) {
            int pivotIndex = partition(l, r);
            quickSort(l, pivotIndex - 1);
            quickSort(pivotIndex + 1, r);
        }
    }
    private int partition(int l, int r) {
        /*
         Swapping the middle element with the last element guarantee better performence when taking the last element as a pivot
         NOTE : you can remove the following swap in line '27' and you will get a stack overflow if the array is sorted and its size is 100000
         */
        swap(l + (r - l ) /2 , r);
        E pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r ; j++) {
            if (arr[j].compareTo(pivot) < 0 ) {
                i++;
                swap(i , j );
            }
        }
        swap(i+1 , r);
        return i+1 ;
    }
    private void swap(int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void print(){
        for(int i = 0 ; i < n ; i++) {
            System.out.print(arr[i].toString()+ " ");
        }
        System.out.println();
    }
}
