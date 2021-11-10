public class CircularArrayQueue<T> {
  private int size;
  private int front, rear;
  private int capacity;
  private T[] array;

  public CircularArrayQueue(int capacity) {
    this.capacity = capacity;
    this.front = size = 0; // index of first item in queue
    this.rear = capacity - 1; // index of the last element in queue
    this.array = (T[]) new Object[capacity];
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
   * Add an item to the queue
   * 
   * @param item
   * @return Added item
   */
  public T enqueue(T item) {
    if (isFull()) {
      System.out.println("ERROR! The queue is currently full");
      return null;
    }
    this.rear = (this.rear + 1) % this.capacity;
    array[this.rear] = item;
    size += 1;
    return item;
  }

  /**
   * Remove an item from the queue
   * 
   * @return Dequeued item
   */
  public T dequeue() {
    if (isEmpty()) {
      System.out.println("ERROR! The queue is empty");
      return null;
    }
    T dequeuedItem = array[this.front];
    this.front = (this.front + 1) % this.capacity;
    size -= 1;
    return dequeuedItem;
  }

  /**
   * Peek first element in the queue
   * 
   * @return Item
   */
  public T peekFront() {
    return this.array[this.front];
  }

  /**
   * Peek first element in the queue
   * 
   * @return Item
   */
  public T peekRear() {
    return this.array[this.rear];
  }

  /**
   * Display all items in the circular queue
   */
  public void display() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
    }
    // front -> rear
    int counter = 0;
    int idx = this.front;
    System.out.print("The queue: ");
    while (counter < size) {
      System.out.print(array[idx]);
      idx = (idx + 1) % this.capacity;
      counter++;
    }
    System.out.print('\n');
  }
}