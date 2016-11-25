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

    System.out.println("pop back: " + list.popBack());
    System.out.println("pop back: " + list.popBack());

    list.printAll("Popped back");

    list.insertAt(1, "five");
    list.insertAt(1, "six");
    list.insertAt(3, "seven");

    list.printAll("InsertAt 5(1),6(1),7(3)");

    list.eraseAt(3);
    list.eraseAt(0);

    list.printAll("EraseAt 3,0");

    System.out.println("2 from end: " + list.valueFromEnd(2));
    System.out.println("1 from end: " + list.valueFromEnd(1));
    System.out.println("Size: " + list.size());

    list.reverse();
    list.printAll("Reverse");

    list.remove("one");
    list.remove("two");

    list.printAll("Removed 1,2");
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
      size++;
    } else {
      current = head;

      while(current.next != null) {
        current = current.next;
      }

      current.next = newNode;
      size++;
    }
  }

  public T popBack() {
    T value = null;
    Node<T> current = null;
    Node<T> previous = null;

    if(head == null) {
      return null;
    } else {
      current = head;

      while(current != null) {
        if(current.next == null) {
          value = current.data;
          previous.next = null;
          size--;

          return value;
        }

        previous = current;
        current = current.next;
      }

      return null;
    }
  }

  public void insertAt(int position, T value) {
    Node<T> current = null;
    Node<T> previous = null;
    Node<T> newNode = new Node<T>(value);
    int count = 0;

    if(head == null && position == 0) {
      head = newNode;
      size++;
    } else if(head == null && position > 0) {
      return;
    } else if(position > size) {
      return;
    } else {
      current = head;

      while(current != null) {
        if(count == position) {
          previous.next = newNode;
          newNode.next = current;
          size++;
        }

        previous = current;
        current = current.next;
        count++;
      }
    }
  }

  public void eraseAt(int position) {
    Node<T> current = null;
    Node<T> previous = null;
    int count = 0;

    if(head == null) {
      return;
    } else if(position == 0) {
      head = head.next;
      size--;
    } else if(position > size) {
      return;
    } else {
      current = head;

      while(current != null) {
        if(count == position) {
          previous.next = current.next;
          size--;
        }

        previous = current;
        current = current.next;
        count++;
      }
    }
  }

  public T valueFromEnd(int position) {
    int count = 0;
    int fromFront = 0;
    Node<T> current = null;

    if(head == null) {
      return null;
    } else if(position > size) {
      return null;
    } else {
      current = head;
      fromFront = (size - position) - 1;

      while(current != null) {
        if(count == fromFront) {
          return current.data;
        }

        current = current.next;
        count++;
      }

      return null;
    }
  }

  public void reverse() {
    Node<T> current = null;
    Node<T> previous = null;
    Node<T> front = null;

    if(head == null || size == 0) {
      return;
    } else {
      current = head;
      front = head.next;

      while(front != null) {
        current.next = previous;

        previous = current;
        current = front;
        front = front.next;
      }

      head = current;
      head.next = previous;
    }
  }

  public void remove(T value) {
    Node<T> current = null;
    Node<T> previous = null;

    if(head == null) {
      return;
    } else if(head.data == value) {
      head = head.next;
      size--;
    } else {
      current = head;

      while(current != null) {
        if(current.data == value) {
          previous.next = current.next;
          size--;
        }

        previous = current;
        current = current.next;
      }
    }
  }
}
