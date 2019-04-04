public class MyLinkedList<E>{
  private Node<E> start;
  private Node<E> end;
  private int size;

  public MyLinkedList(){
    size = 0;
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

  public boolean add(E e){
    if (end == null) { // if list is totally empty
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
      other.start.setPrev(end);
    }
    other.start = null;
    other.end = null;
    size += other.size();
    other.size = 0;
  }

  private Node getNode(int index) {
    int current = 0;
    Node ans = start;
    while (current < index) {
      ans = ans.getNext();
      current++;
    }
    return ans;
  }

  public E remove(int index){
    E ans = (E) getNode(index).getData();
    if (index == 0) {
     start = getNode(index+1);
     return ans;
    }
    if (getNode(index).getNext() == null) {
     getNode(index-1).setNext(end);
     end = getNode(index-1);
     end.setNext(null);
     size--;
     return ans;
    }
    getNode(index-1).setNext(getNode(index+1));
    getNode(index).setPrev(getNode(index-1));
    size--;
    return ans;
  }

  public static void main(String[] args){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    System.out.println(test);
    test.add(1);
    test.add(2);
    test.add(3);
    System.out.println(test);
    System.out.println(test.remove(0));
    System.out.println(test.remove(0));
    System.out.println(test.remove(0));
    System.out.println(test);
  }
}
