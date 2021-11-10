public class StackApplication {
  public static void main(String[] args) {
    /// 1. Detect imbalance brackets
    String balanceQuestion = "(){{[]}}()"; // 1a
    String imbalanceQuestion = "{{[[}}]]"; // 1b
    // 1a. Solve balance question
    if (checkBalanceBrackets(balanceQuestion) == true) {
      System.out.println("1a. Balance");
    } else {
      System.out.println("1a. Imbalance");
    }
    // 1b. Solve imbalance question
    if (checkBalanceBrackets(imbalanceQuestion) == true) {
      System.out.println("1b. Balance");
    } else {
      System.out.println("1b. Imbalance");
    }

  }

  public static boolean checkBalanceBrackets(String brackets) {
    ArrayStack<Character> stack = new ArrayStack<Character>(20); // Capacity is 20 characters
    // Solve balance one
    for (int i = 0; i < brackets.length(); i++) {
      Character character = brackets.charAt(i);
      if (character == '[' || character == '(' || character == '{') {
        stack.push(character);
        continue;
      }
      Character check;
      switch (character) {
      case ']':
        check = stack.peek();
        if (check == '[') {
          stack.pop();
        }
        break;
      case ')':
        check = stack.peek();
        if (check == '(') {
          stack.pop();
        }
        break;
      case '}':
        check = stack.peek();
        if (check == '{') {
          stack.pop();
        }
        break;
      }
    }
    if (stack.top >= 0) {
      return false;
    }
    return true;

  }
}