public class QueueApplication {
  public static void main(String[] args) {
    PeopleQueue queue = new PeopleQueue();
    Person a = new Person("s1", 20);
    Person b = new Person("s2", 64);
    Person c = new Person("s3", 66);
    // Join queue
    queue.joinQueue(a);
    queue.joinQueue(b);
    queue.joinQueue(c);
    queue.display();
    System.out.println("After dequeueing for vaccination");
    // Starting to get vaccine
    queue.getVaccine();
    queue.getVaccine();
    queue.display();
    // A few more people is coming to the line
    queue.joinQueue(new Person("s4", 20));
    queue.joinQueue(new Person("s5", 40));
    queue.joinQueue(new Person("s6", 78));
    // Then suddenly person with ID s5 give up because of impatience
    queue.giveUp("s5");
    queue.display();
  }
}

class Person {
  public String ID;
  public int age;

  public Person(String ID, int age) {
    this.ID = ID;
    this.age = age;
  }
}

class PeopleQueue extends ArrayQueue<Person> {
  // Person whose age is >= 65 -> Go before person < 65;

  public PeopleQueue() {
    super(Person.class, 100);
  }

  /**
   * Put a person joined in the queue
   * 
   * @param person Enqueued person
   */
  public void joinQueue(Person person) {
    if (isFull()) {
      System.out.println("ERROR! The queue is currently full. Please await!");
    }
    this.size += 1;
    this.array[size - 1] = person;
    System.out.println("SUCCESS! Person with ID: " + person.ID + " entered queued successfully");
  }

  /**
   * Dequeue a person and have him/her vaccinated
   * 
   * @return Dequeued person
   */
  public Person getVaccine() {
    int firstIdx = 0;
    // CASE EMPTY
    if (isEmpty()) {
      System.out.println("ERROR! The queue is currently empty");
      return null;
    }
    // SPECIAL CASE: There more than 1 elements and There is a >= 65 year-old person
    // behind => Swap the position for prioritizing 65-year-old people
    if (this.size > 1 && array[firstIdx + 1].age >= 65 && array[firstIdx].age < 65) {
      swap(firstIdx, firstIdx + 1, array);
      Person dequeuedPerson = this.dequeue();
      System.out
          .println("SUCCESS! Person with ID: " + dequeuedPerson.ID + " has got vaccinated successfully with priority");
      return dequeuedPerson;
    }
    Person dequeuedPerson = this.dequeue();
    System.out.println("SUCCESS! Person with ID: " + dequeuedPerson.ID + " has got vaccinated successfully");

    return dequeuedPerson;
  }

  public void giveUp(String ID) {
    // Find the person and his/her index
    int personIdx = -1;
    for (int i = 0; i < size; i++) {
      if (array[i].ID.equals(ID)) {
        personIdx = i;
        break;
      }
    }
    if (personIdx == -1) {
      System.out.println("ERROR! Cannot find the person with ID " + ID + " in the queue");
      return;
    }
    // Shift the array to left from that person
    for (int i = personIdx; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    // Set the last reference to null to free memory and avoid unwanted reference
    array[size - 1] = null;
    size -= 1;
  }

  /**
   * Swap people in the queue
   * 
   * @param idxA
   * @param idxB
   * @param array
   */
  public void swap(int idxA, int idxB, Person[] array) {
    Person temp = array[idxA];
    array[idxA] = array[idxB];
    array[idxB] = temp;
  }

  @Override
  public void display() {
    if (isEmpty()) {
      System.out.println("The queue is currently empty");
      return;
    }
    System.err.print("Current queue: ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i].ID + " ");
    }
    System.out.print("\n");
  }
}