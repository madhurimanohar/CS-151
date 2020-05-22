package array;

public class Arrays {
   public static void swapLargestAndSmallest(int[] a) {
       int small = smallestIndex(a);
       int large = largestIndex(a);
       
       swap(a, small, large);
   }

   public static int smallestIndex(int[] a) {
       int max = a[0];
       int pos = 0;
       for(int i = 0; i < a.length; i++) {
           if(max < a[i]) {
               max = a[i];
               pos = i;
           }
       }
       return pos;
   }
   
   public static int largestIndex(int[] a) {
       int min = a[0];
       int pos = 0;
       for(int i = 0; i < a.length; i++) {
           if(min > a[i]) {
               min = a[i];
               pos = i;
           }
       }
       return pos;
   }
   
   public static void swap(int[] a, int first, int second) {
       int temp = a[first];
       a[first] = a[second];
       a[second] = temp;
   }
   
}
