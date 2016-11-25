public class RCLinkedList<T> {

  private Node<T> head;
  private int size;

  class Node<R> {
    public R data;
    public Node<R> next;

    public Node(R value) {
      data = value;
      next = null;
    }
  }

  public static void main(String[] args) {
    System.out.println("Linked List");

    RCLinkedList<String> list = new RCLinkedList<String>();

    System.out.println("Size: " + list.size());
    System.out.println("IsEmpty: " + list.isEmpty());

    list.pushBack("one");
    list.pushBack("two");
    list.pushBack("three");
    list.pushBack("four");

    list.printAll("PushBack");
  }

  public RCLinkedList() {
    head = null;
    size = 0;
  }

  public void printAll(String operation) {
    Node<T> current = null;
    current = head;

    System.out.print(operation + ": ");
    while(current != null) {
      System.out.print(current.data + ",");
      current = current.next;
    }
    System.out.println();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T valueAt(int position) {
    int count = 0;
    Node<T> current = null;

    if(head == null) {
      return null;
    } else if(position > size) {
      return null;
    } else {
      current = head;

      while(current != null) {
        if(count == position) {
          return current.data;
        }

        current = head.next;
        count++;
      }

      return null;
    }
  }

  public void pushBack(T value) {
    Node<T> current = null;
    Node<T> newNode = new Node<T>(value);

    if(head == null) {
      head = newNode;
    } else {
      current = head;

      while(current.next != null) {
        current = current.next;
      }

      current.next = newNode;
      current.size++;
    }
  }
}
