public class CircularLinkedListQueueImplementation {
  public static void main(String[] args) {
    // Init circular queue
    CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<Integer>();
    // Enqueue
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    Integer enqueuedItem = queue.enqueue(5);
    System.out.println("5th enqueued item is: " + enqueuedItem);
    // Dequeue
    queue.dequeue();
    Integer secondDequeuedItem = queue.dequeue();
    System.out.println("2nd Dequeued item is: " + secondDequeuedItem);
    queue.display();
    // Peek
    System.out.println("Peek Front item is: " + queue.peekFront());
    System.out.println("Peek Rear item is: " + queue.peekRear());

  }
}

class CircularLinkedListQueue<T> {
  static class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int capacity;
  public final static int MAX_CAPACITY = 1000;
  private Node<T> front, rear;
  private int size;

  public CircularLinkedListQueue() {
    this.capacity = MAX_CAPACITY;
  }

  public CircularLinkedListQueue(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Check if queue is empty
   * 
   * @return True if empty | False if not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Check if queue is full
   * 
   * @return True if full | False if not
   */
  public boolean isFull() {
    return size == capacity;
  }

  /**
   * Get current size of the queue
   * 
   * @return Queue's size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Add an item to queue
   * 
   * @param item Item to be added
   * @return Added item
   */
  public T enqueue(T item) {
    if (isFull()) {
      System.out.println("ERROR! The queue is full");
      return null;
    } else if (isEmpty()) {
      Node<T> enqueuedNode = new Node<T>(item);
      this.front = this.rear = enqueuedNode;
      this.rear.next = this.front;
      size += 1;
      return item;
    }
    // If there's already one at the front
    Node<T> enqueuedNode = new Node<T>(item);
    enqueuedNode.next = this.rear.next;
    this.rear.next = enqueuedNode;
    this.rear = enqueuedNode;
    size += 1;
    return item;
  }

  /**
   * Dequeue an item from the queue
   * 
   * @return Dequeued item
   */
  public T dequeue() {
    if (isEmpty()) {
      System.out.println("ERROR! The queue is currently empty");
      return null;
    }
    T item = this.front.data;
    Node<T> temp = this.front.next;
    this.front = temp;
    this.rear.next = this.front;
    return item;
  }

  /**
   * Peek the first item of the queue
   * 
   * @return First item of queue
   */
  public T peekFront() {
    return this.front.data;
  }

  /**
   * Peek the last item of the queue
   * 
   * @return Last item of queue
   */
  public T peekRear() {
    return this.rear.data;
  }

  /**
   * Print all current elements of the queue
   */
  public void display() {
    if (isEmpty()) {
      System.err.println("The queue is currently empty!");
      return;
    }
    Node<T> cur = this.front;
    // Traverse to the last element
    while (cur.next != this.front) {
      System.out.print(cur.data + " ");
      cur = cur.next;
    }
    // Print last item
    System.out.print(cur.data + "\n");
  }
}
