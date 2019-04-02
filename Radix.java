public class Radix{
  public static MyLinkedList<Integer>[] buckets;

  public static void radixsort(int[] data){
    buckets = new MyLinkedList[20];
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
    System.out.println(maxDigit(test));
  }
}
