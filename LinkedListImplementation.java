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

class LinkedList {
  public Node head;

  static class Node {
    public int value;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  /**
   * Insert/Append a new value to
   * 
   * @param value
   * @return
   */
  public Node insert(int value) {

    // If linked list is empty
    if (head == null) {
      Node insertedNode = new Node(value);
      this.head = insertedNode;
      head.next = null;
      return insertedNode;
    } else {
      // Traverse to the end of node
      Node insertedNode = new Node(value);
      Node cur = this.head;
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = insertedNode;
      return insertedNode;
    }
  }

  /**
   * Delete node of linked list by key/value
   * 
   * @param key
   * @return
   */
  public Node deleteAtKey(int key) {
    // Init pointers
    Node cur = this.head;
    Node prev = null;

    // CASE 1: Delete at head
    if (cur != null && cur.value == key) {
      this.head = cur.next;
      System.out.println(key + " was found and deleted");
      return cur;
    }

    // Traverse until key is matched or not null
    while (cur != null && cur.value != key) {
      prev = cur;
      cur = cur.next;
    }

    // CASE 2: Delete at middle or above
    if (cur != null) {
      prev.next = cur.next;
      System.out.println(key + " was found and deleted");
      return cur;
    }

    System.out.println(key + " was not found");
    return null;

  }

  public Node deleteByPos(int pos) {
    /**
     * Success Flow: CASE 1: Delete at Head CASE 2: Delete at Middle CASE 3: Pos
     * exceeded/Not-found CASE 3: Not found
     */
    // 2 pointers
    Node prev = null;
    Node cur = this.head;

    // CASE 1: DELETE AT Head
    if (cur != null && pos == 0) {
      this.head = cur.next;
      System.out.println("Node at position " + pos + " deleted");
      return cur;
    }

    int idxCounter = 0;
    // Traverse from the beginning
    while (cur != null && idxCounter != pos) {
      prev = cur;
      cur = cur.next;
      idxCounter++;
    }

    // CASE 2: Delete at Middle
    if (cur != null) {
      prev.next = cur.next;
      System.out.println("Node at position " + pos + " deleted");
      return cur;
    }

    System.out.println("Cannot delete node at position " + pos);

    return null;
  }

  /**
   * Print list of nodes' values in the linked list
   */
  public void printList() {
    Node cur = this.head;
    System.out.print("Linked list: ");

    while (cur != null) {
      System.out.print(cur.value + " ");
      cur = cur.next;
    }
  }
}