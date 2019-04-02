public class Radix{
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i=0; i<data.length; i++){
      if (data[i] % 10 == i){
        if (data[i] < 0){
          buckets[9-i].add(data[i]);
        } else {
          buckets[10+i].add(data[i]);
        }
      }
    }
  }
}
