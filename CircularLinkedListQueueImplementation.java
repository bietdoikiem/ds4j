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
