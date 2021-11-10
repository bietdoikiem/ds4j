class LinkedListImplementation {
  public static void main(String[] args) {
    System.out.println("=== Welcome to DataStructure4J ===");
    // LinkedList Demo
    LinkedList list = new LinkedList();
    // Insert
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    // Print details
    list.printList();
    System.out.println('\n');
    // Delete at key
    // LinkedList.Node node = list.deleteAtKey(9);
    // System.out.println("Deleted key was: " + node.value);

    // Delete at position
    list.deleteByPos(0);
    list.printList();
  }
}
