import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameInverterTest {

  private NameInverter nameInverter = new NameInverter();

  @Test
  @DisplayName("nothing")
  public void nothing() throws Exception {
  }

  @Test
  @DisplayName("name")
  public void name() throws Exception {
    Assertions.assertEquals(nameInverter.invert(null), "");
    Assertions.assertEquals(nameInverter.invert(""), "");
    Assertions.assertEquals(nameInverter.invert("name"), "name");
    Assertions.assertEquals(nameInverter.invert("first last"), "last, first");
    Assertions.assertEquals(nameInverter.invert("   name   "), "name");
    Assertions.assertEquals(nameInverter.invert("first     last"), "last, first");
    Assertions.assertEquals(nameInverter.invert("Mr. first last"), "last, first");
    Assertions.assertEquals(nameInverter.invert("Mrs. first last"), "last, first");
    Assertions.assertEquals(nameInverter.invert("Mrs. first last SR."), "last, first SR.");
    Assertions.assertEquals(nameInverter.invert("Mrs. first last BS. Phd."),
        "last, first BS. Phd.");
    Assertions.assertEquals(nameInverter.invert("   Robert Martin II esq."),
        "Martin, Robert II esq.");
  }

}
