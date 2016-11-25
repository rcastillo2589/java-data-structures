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

    System.out.println("valueAt 0: " + list.valueAt(0));
    System.out.println("valueAt 3: " + list.valueAt(3));

    list.pushFront("zero");
    list.pushFront("neg-one");
    list.pushFront("neg-two");

    list.printAll("PushFront");

    System.out.println("pop front: " + list.popFront());
    System.out.println("pop front: " + list.popFront());

    list.printAll("Popped");
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

        current = current.next;
        count++;
      }

      return null;
    }
  }

  public void pushFront(T value) {
    Node<T> temp = null;
    Node<T> newNode = new Node<T>(value);

    if(head == null) {
      head = newNode;
      size++;
    } else {
      temp = head;
      head = newNode;
      head.next = temp;
      size++;
    }
  }

  public T popFront() {
    Node<T> poppedNode = null;

    if(head == null) {
      return null;
    } else {
      poppedNode = head;
      head = head.next;
      size--;

      return poppedNode.data;
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
      size++;
    }
  }
}
