public class LinkedListStackImplementation {
  // Implementation
  public static void main(String[] args) {
    LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    Integer poppedInt = stack.pop();
    System.out.println("Popped integer is: " + poppedInt);
    stack.display();
  }
}

class LinkedListStack<T> {
  static class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int currentSize;
  private Node<T> head;

  public LinkedListStack() {
    this.currentSize = 0;
  }

  /**
   * Push a new item to the stack
   * 
   * @param item Item to be pushed
   * @return Pushed item
   */
  public T push(T item) {
    Node<T> pushedItem = new Node<T>(item);
    // CASE 1: Push at the head
    if (isEmpty()) {
      this.head = pushedItem;
      this.currentSize++;
      return item;
    }
    // CASE 2: Push at the middle => Reference current head's next to new one && set
    // the head pointer to the pushed element
    pushedItem.next = this.head;
    this.head = pushedItem;
    this.currentSize++;
    return item;
  }

  /**
   * Pop an item from the stack
   * 
   * @return Popped item
   */
  public T pop() {
    if (isEmpty()) {
      System.out.println("ERROR! Stack is empty");
      return null;
    }
    Node<T> poppedNode = this.head;
    this.head = this.head.next;
    System.out.println("Popped node: " + poppedNode.data);
    return poppedNode.data;

  }

  /**
   * Check if the stack is empty by its size
   * 
   * @return True if empty | False if not
   */
  public boolean isEmpty() {
    return currentSize == 0;
  }

  /**
   * Print the items of the Stack (from top to bottom)
   */
  public void display() {
    if (isEmpty()) {
      System.out.println("The stack is empty");
    } else {
      Node<T> cur = this.head;
      while (cur != null) {
        System.out.println(cur.data);
        cur = cur.next;
      }
    }
  }

}