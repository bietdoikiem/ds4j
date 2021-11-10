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
