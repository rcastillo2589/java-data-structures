
public class RCVector<T> {
  private final int INITIAL_SIZE = 4;

  private T[] data;
  private int size;

  public static void main(String[] args) {

  }

  public RCVector() {
    data = new T[INITIAL_SIZE];
    size = 0;
  }

  public void insert(T value) {
    if(size == data.length) {
      resize(data.length * 2);
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

  public void getSize() {
    return size;
  }

  public static void resize(int newSize) {
    T[] temp = new T[newSize];
    System.arraycopy(data, 0, temp, 0, data.length);
    data = new T[newSize];
    data = temp;
  }

  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }

    return false;
  }

  public T valueAt(int index) {
    return data[index];
  }

  public void push(T value) {
    if(size == data.length) {
      resize(data.length * 2);
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
    size--;
  }

  public T pop() {
    T value = data[size - 1];
    size--;

    if(size == data.length / 4) {
      resize(data.length / 2);
    }

    return value;
  }
}
