import java.util.*;

public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> temp = new MyLinkedList<Integer>();
    int maxD = maxDigit(data);
    for (int i=0; i<buckets.length; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }

    for (int d=1; d<=maxD; d++){
      if (d == 1){
        for (int i=0; i<data.length; i++){
          int n = data[i];
          int pos = (int) (n / Math.pow(10,d-1)) % 10;
          buckets[pos+9].add(n);
        }
        for (int i = 0; i < 20; i++) {
          temp.extend(buckets[i]);
        }
        for (MyLinkedList<Integer> bucket : buckets) {
          bucket.clear();
        }
      } else {
        for (int i=0; i<data.length; i++) {
          int n = temp.removeFront();
          int pos = (int)(n / (Math.pow(10,d-1))) % 10;
          buckets[pos+9].add(n);
        }
        temp.clear();
        for (int i=0; i<20; i++) {
          temp.extend(buckets[i]);
        }
        for (MyLinkedList<Integer> bucket : buckets) {
          bucket.clear();
        }
      }
    }
    for (int i=0; i<data.length; i++) {
      data[i] = temp.removeFront();
    }
  }

  private static int maxDigit(int[] data){
    if (data.length == 0){
      return 0;
    }
    int max = data[0];
    for (int i=0; i<data.length; i++){
      if (Math.abs(data[i]) > max){
        max = data[i];
      }
    }
    if (max < 0){
      max = max * -1;
    }
    String maxString = max + "";
    return maxString.length();
  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
