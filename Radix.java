public class Radix{

  public static void radixsort(int[] data){
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
          int pos = (int) (n / Math.pow(10,i-1)) % 10;
          buckets[pos+9].add(n);
        }
        temp.clear();
        for (int i = 0; i < 20; i++) {
          temp.extend(buckets[i]);
        }
        for (MyLinkedList<Integer> bucket : buckets) {
          bucket.clear();
        }
      } else {
        for (int i=0; i<data.length; i++) {
          int n = temp.removeFront();
          int pos = (int)(n / (Math.pow(10,i-1))) % 10;
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
