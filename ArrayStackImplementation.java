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