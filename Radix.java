public class Radix{
  private static MyLinkedList<Integer>[] buckets;

  public static void radixsort(int[] data){
    buckets = new MyLinkedList[20];
    int maxD = maxDigit(data);
//    for (int d=1; d<=maxD; d++){
      for (int i=0; i<data.length; i++){
        int lastDigit = data[i] % 10;
        if (data[i] < 0){
          buckets[9-lastDigit].add(data[i]);
        } else {
          buckets[10+lastDigit].add(data[i]);
        }
      }

      int count = 0;
      for (int i=0; i<buckets.length; i++){
        System.out.println(buckets[i]);
        // while (buckets[i].size() > 0){
        //   data[count] = buckets[i].removeFront();
        //   count++;
        // }
      }
    //}
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

  public static void main(String[] args){
    int[] test = {1,2,3, -300000};
    radixsort(test);
    System.out.print("[");
    for (int i=0; i<test.length; i++){
      System.out.print(test[i] + ",");
    }
    System.out.println("]");
  }
}