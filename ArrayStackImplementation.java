class ArrayStackImplementation {
  public static void main(String[] args) {
    // Init stack whose maximum size is 5 items
    ArrayStack<Integer> intStack = new ArrayStack<Integer>(5);
    intStack.push(1);
    intStack.push(2);
    intStack.push(3);
    intStack.push(4);
    intStack.push(5);
    // intStack.push(6); // Test Stack Overflow push operation

    // Pop item
    // Integer popped = intStack.pop();
    // System.out.println("Popped item is: " + popped);
    // System.out.println("Current top index after popping is: " + intStack.top);

    // Peek item
    Integer peeked = intStack.peek();
    System.out.println("Peeked item is: " + peeked);

  }
}

class ArrayStack<T> {
  public final int maxSize;
  public T[] array;
  public int top = -1; // Index of top element

  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    this.array = (T[]) new Object[maxSize];
  }

  /**
   * Check if the stack is empty | Time complexity: O(1)
   * 
   * @return True if empty | False if NOT
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Push new item to the stack | Time complexity: O(1)
   * 
   * @param item Stack's item to be pushed
   * @return True if success | Throws Stack Overflow error if exceed the maximum
   *         size
   */
  public T push(T item) {
    if (top < (maxSize - 1)) {
      array[++top] = item;
      System.out.println("SUCCESS! Push item to the stack at index: " + top);
      return item;
    }
    // CASE ERROR: Check if we have push exceeding the limit
    System.out.println("ERROR! The stack is full already");
    return null;
  }

  /**
   * Pop the item from top of the stack | Time complexity: O(1)
   * 
   * @return True if success | False if not
   */
  public T pop() {
    // CASE ERROR: Check if we have nothing to pop
    if (top == -1) {
      System.out.println("ERROR! The stack is empty");
      return null;
    }
    // CASE SUCCESS
    T poppedItem = array[top];
    array[top--] = null;
    return poppedItem;
  }

  /**
   * Peek the item at the top of the stack | Time complexity: O(1)
   * 
   * @return Item at the top of the stack
   */
  public T peek() {
    return array[top];
  }

}