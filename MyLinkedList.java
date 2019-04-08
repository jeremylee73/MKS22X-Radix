public class MyLinkedList<E>{
  private Node start;
  private Node end;
  private int size;

  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }

  public String toString(){
    String ans = "[";
    if (size == 0 || start == null || end == null){
      return "[]";
    }
    Node current = start;
    while (current.getNext() != null){
      ans += current.getData() + ",";
      current = current.getNext();
    }
    ans += current.getData() + "]";
    return ans;
  }

  public void clear(){
    size = 0;
    start = null;
    end = null;
  }

  public boolean add(int e){
    if (end == null) {
      end = new Node(e,end,null);
      start = end;
    } else {
      Node newNode = new Node(e, end.getPrev(), null);
      end.setNext(newNode);
      end = newNode;
    }
    size++;
    return true;
  }

  public int size(){
    return size;
  }

  public void extend(MyLinkedList<E> other){
    if (size == 0) {
      start = other.start;
      end = other.end;
    } else if (other.size() != 0) {
      end.setNext(other.start);
      end = other.end;
      other.start.setPrev(end);
    }
    size += other.size();
  }

  public int removeFront(){
    int ans = start.getData();
    start = start.getNext();
    return ans;
  }

  public static void main(String[] args){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    System.out.println(test);
    test.add(1);
    test.add(2);
    test.add(3);
    System.out.println(test);
    System.out.println(test.removeFront());
    System.out.println(test.removeFront());
    System.out.println(test.removeFront());
    System.out.println(test);
  }
}
