import java.util.ArrayList;
public class MergeSort<E extends Comparable<E>> implements  SortingTechnique{
    E[] arr;
    int n;
    public MergeSort(E[] arr) {
        this.arr = arr;
        n = arr.length;
    }
    public void sort() {
        mergeSort(0, n - 1);
    }
    private void merge(int l1, int r1, int l2, int r2) {
        ArrayList<E> sorted = new ArrayList<E>();
        int size = r2 - l1 + 1;
        int start = l1;
        while (l2 <= r2 && l1 <= r1) {
            if (arr[l1].compareTo(arr[l2]) < 0) {
                sorted.add(arr[l1]);
                l1++;
            } else {
                sorted.add(arr[l2]);
                l2++ ;
            }
        }
        for(int i = l1 ; i<= r1 ; i++ ){
            sorted.add(arr[i]) ;
        }
        for(int i = l2 ; i<= r2 ; i++ ){
            sorted.add(arr[i]) ;
        }
        for(int i = start  ; i< start + size ; i++) {
            arr[i] = sorted.get(i - start) ;
        }
    }
    private void mergeSort(int l, int r) {// Note case of l = 0 , r = 1

        if(l >= r ) return;
        int mid = l + (r - l) / 2;
        mergeSort(l, mid );
        mergeSort(mid+1, r);
        merge(l, mid , mid+1, r);
    }

    public void print() {
        for(int i = 0 ; i < n ; i++ ){
            System.out.print(arr[i].toString() + " ");
        }
    }
}
