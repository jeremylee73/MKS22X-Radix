public class MyLinkedList<E>{
  private Node<E> start;
  private Node<E> end;
  private int size;

  public MyLinkedList(){
    size = 0;
  }

  public String toString(){
    String ans = "[";
    if (end == null){
      return "[]";
    }
    Node current = start;
    ans += current.getData() + ",";
    while (current.getNext() != null){
      current = current.getNext();
      if (current.getNext().getNext() == null){
        ans += current.getData() + "]";
      } else {
        ans += current.getData() + ",";
      }
    }
    return ans;
  }

  public void clear(){
    size = 0;
    start = null;
    end = null;
  }

  public boolean add(E e){
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
      other.start.setPrev(end);
    }
    other.start = null;
    other.end = null;
    size += other.size();
    other.size = 0;
  }

  public E removeFront(){
    return start.getData();
  }

  public static void main(String[] args){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    System.out.println(test);
  }
}
