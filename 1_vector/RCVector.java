
public class RCVector<T> {
  private final int INITIAL_SIZE = 4;

  private Object[] data;
  private int size;

  public static void main(String[] args) {
    RCVector<String> vector = new RCVector<String>();

    System.out.println("IsEmpty: " + vector.isEmpty());
    vector.insert("one");
    vector.insert("two");
    vector.insert("three");
    vector.insert("four");
    vector.insert("five");

    vector.printAll("Inserts");

    vector.delete(0);
    vector.delete(0);

    vector.printAll("Delete 0 2x");
    System.out.println("GetSize: " + vector.getSize());
    System.out.println("IsEmpty: " + vector.isEmpty());

    vector.push("six");
    vector.push("seven");
    vector.push("eight");

    System.out.println("ValueAt 4: " + vector.valueAt(4));
    System.out.println("ValueAt 2: " + vector.valueAt(2));

    vector.printAll("Push");

    vector.prepend("zero");
    vector.prepend("neg-one");
    vector.prepend("neg-two");

    vector.printAll("Prepend(3x)");
    System.out.println("GetSize: " + vector.getSize());

    vector.pop();
    vector.pop();

    System.out.println("GetSize: " + vector.getSize());
    vector.printAll("Pop(2x)");
  }

  public RCVector() {
    data = new Object[INITIAL_SIZE];
    size = 0;
  }

  public void printAll(String operations) {
    System.out.print(operations + ": ");
    for(int i = 0; i < size; i++) {
      System.out.print((T)data[i] + ",");
    }
    System.out.println();
  }

  public void insert(T value) {
    if(size == data.length) {
      resize(data.length * 2);
      data[size++] = value;
    } else {
      data[size++] = value;
    }
  }

  public void delete(int index) {
    data[index] = null;

    for(int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }

    size--;

    if(size == data.length / 4) {
      resize(data.length / 2);
    }
  }

  public int getSize() {
    return size;
  }

  public void resize(int newSize) {
    Object[] temp = new Object[newSize];
    System.arraycopy(data, 0, temp, 0, size);
    data = new Object[newSize];
    data = temp;
  }

  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }

    return false;
  }

  public T valueAt(int index) {
    return (T)data[index];
  }

  public void push(T value) {
    if(size == data.length) {
      resize(data.length * 2);
      data[size++] = value;
    } else {
      data[size++] = value;
    }
  }

  public void prepend(T value) {
    if(size == data.length) {
      resize(data.length * 2);
    }

    for(int i = size; i > 0; i--) {
      data[i] = data[i - 1];
    }

    data[0] = value;
    size++;
  }

  public T pop() {
    Object value = data[size - 1];
    size--;

    if(size == data.length / 4) {
      resize(data.length / 2);
    }

    return (T)value;
  }
}
