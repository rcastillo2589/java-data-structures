public class RCQueue<T> {

  private Node<T> head;
  private Node<T> tail;
  private int length;

  class Node<R> {
    public R data;
    public Node<R> next;

    public Node(R value) {
      data = value;
      next = null;
    }
  }

  public static void main(String[] args) {
    RCQueue<String> queue = new RCQueue<String>();

    System.out.println("IsEmpty: " + queue.isEmpty());
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");
    queue.enqueue("four");
    queue.enqueue("five");
    queue.print("Enqueued 1-5");
    System.out.println("IsEmpty: " + queue.isEmpty());

    System.out.println("Dequeue: " + queue.dequeue());
    System.out.println("Dequeue: " + queue.dequeue());

    queue.print("Dequeued");
  }

  public RCQueue() {
    head = null;
    tail = null;
    length = 0;
  }

  public void enqueue(T data) {
    Node<T> newValue = new Node<T>(data);

    if(tail == null) {
      tail = newValue;
      head = newValue;
      length++;
    } else {
      tail.next = newValue;
      tail = tail.next;
      length++;
    }
  }

  public T dequeue() {
    T value = null;

    if(tail == null) {
      return null;
    } else {
      value = head.data;
      head = head.next;
      length--;

      return value;
    }
  }

  public boolean isEmpty() {
    if(length == 0) {
      return true;
    } else {
      return false;
    }
  }

  public void print(String operation) {
    Node<T> current = null;

    current = head;
    System.out.print(operation + ": ");
    while(current != null) {
      System.out.print(current.data + ",");
      current = current.next;
    }
    System.out.println();
  }
}
