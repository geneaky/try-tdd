import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyStackTest {

  @Test
  @DisplayName("pop")
  public void pop() throws Exception {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);

    assertEquals(stack.pop(), 2);
    assertEquals(stack.pop(), 1);
  }

}
