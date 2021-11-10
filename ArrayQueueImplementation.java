public class ArrayQueueImplementation {
  public static void main(String[] args) {
    // Init a queue
    ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    // Enqueue
    Integer enqueuedItem = queue.enqueue(5);
    System.out.println("Recent enqueued item is: " + enqueuedItem);
    queue.display();
    // Dequeue
    Integer dequeuedItem = queue.dequeue();
    System.out.println("Recent dequeued item is: " + dequeuedItem);
    queue.display();
    // Peek front
    Integer peekFrontItem = queue.peekFront();
    System.out.println("The first item of the queue is: " + peekFrontItem);
    // Peek rear
    Integer peekRearItem = queue.peekRear();
    System.out.println("The last item of the queue is: " + peekRearItem);
  }
}

class ArrayQueue<T> {
  private int capacity;
  private int size;
  private T[] array;

  public ArrayQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.array = (T[]) new Object[capacity];
  }

  /**
   * Get the current size of the queue
   * 
   * @return
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Check if the queue is currently empty
   * 
   * @return True if empty | False if not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Check if the queue is full
   * 
   * @return True if empty | False if not
   */
  public boolean isFull() {
    return size == capacity;
  }

  /**
   * Enqueue an item to the queue | Time complexity: O(1)
   * 
   * @param item
   * @return
   */
  public T enqueue(T item) {
    // CASE 1: If queue is full
    if (isFull()) {
      System.out.println("ERROR! The queue is currently full!");
      return null;
    }
    // CASE 2: If queue is still insert-able
    size++;
    array[size - 1] = item;
    return item;
  }

  /**
   * Dequeue an item from the queue | Time complexity: O(n)
   * 
   * @return Dequeued item
   */
  public T dequeue() {
    if (isEmpty()) {
      System.out.println("ERROR! The queue is currently empty");
      return null;
    }
    T poppedItem = array[0];
    // Shift all items to left
    for (int i = 0; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    // Set null to last dangling item in queue
    array[size - 1] = null;
    size--;
    return poppedItem;
  }

  /**
   * Peek at the first item in the queue | Time complexity: O(1)
   * 
   * @return Item
   */
  public T peekFront() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return null;
    }
    return array[0];
  }

  /**
   * Peek at the last item of the queue | Time complexity: O(1)
   * 
   * @return
   */
  public T peekRear() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return null;
    }
    return array[size - 1];
  }

  /**
   * Display all the items currently in the queue | Time complexity: O(n)
   */
  public void display() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return;
    }
    System.err.print("The queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.print("\n");
  }

}
