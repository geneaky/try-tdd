import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MailBoxTest {

  @Test
  @DisplayName("nothing")
  public void nothing() throws Exception {
  }

  @Test
  @DisplayName("newMailBox_should_empty")
  public void newMailBox_should_empty() throws Exception {
    MailBox mailbox = new MailBox();
    assertEquals(mailbox.messageCount(), 0);
  }


}
