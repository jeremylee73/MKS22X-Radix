public class Node<E>{
  private E data;
  private Node<E> prev, next;

  public Node(E data, Node<E> prev, Node<E> next){
    this.data = data;
    this.prev = prev;
    this.next = next;
  }

  public E getData(){
    return data;
  }
  public Node<E> getNext(){
    return next;
  }
  public Node<E> getPrev(){
    return prev;
  }
  public void setData(E data){
    this.data = data;
  }
  public void setNext(Node<E> next){
    this.next = next;
  }
  public void setPrev(Node<E> prev){
    this.prev = prev;
  }
}
