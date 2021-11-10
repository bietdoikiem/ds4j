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
