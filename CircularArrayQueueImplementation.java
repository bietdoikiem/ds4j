public class CircularArrayQueueImplementation {
  public static void main(String[] args) {
    // Init a circular queue
    CircularArrayQueue<Integer> queue = new CircularArrayQueue<Integer>(5);
    // Enqueue
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    Integer enqueuedItem = queue.enqueue(5);
    System.out.println("5th enqueued item is: " + enqueuedItem);
    // Dequeue
    Integer dequeuedItem = queue.dequeue();
    System.out.println("Dequeued item is: " + dequeuedItem);
    queue.display();
    // Peak front
    System.out.println("Peek front item: " + queue.peekFront());
    System.out.println("Peek rear item: " + queue.peekRear());

  }
}
