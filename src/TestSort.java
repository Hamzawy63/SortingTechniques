import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestSort {
    public static void main(String[] args) {
        Integer[] arr = {1,8,87,3,2,0,4,66,4} ;
        //Integer[] arr = {1,8,87,9} ;
     //   for(int i = 0 ; i < 1000 ; i++) arr[i] = (int)Math.random() * 10000 + 1  ;
        SortingTechnique quickSort = new MergeSort((arr)) ;

        //quickSort.print();
        long f  =System.nanoTime() ;
        quickSort.sort();
        long s = System.nanoTime();
        System.out.println("Done in " + (s-f));
        quickSort.print();
    }
}
