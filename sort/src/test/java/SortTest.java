import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortTest {

  @Test
  @DisplayName("sort")
  public void sort() throws Exception {
    Assertions.assertEquals(sort(intList()), intList());
    Assertions.assertEquals(sort(intList(1)), intList(1));
    Assertions.assertEquals(sort(intList(2, 1)), intList(1, 2));
    Assertions.assertEquals(sort(intList(2, 3, 1)), intList(1, 2, 3));
    Assertions.assertEquals(sort(intList(1, 3, 2)), intList(1, 2, 3));
    Assertions.assertEquals(sort(intList(3, 2, 1, 2)), intList(1, 2, 2, 3));

  }

  private List<Integer> intList(Integer... numbers) {
    return Arrays.asList(numbers);
  }

  private List<Integer> sort(List<Integer> list) {
    List<Integer> sorted = new ArrayList<>();
    if (list.size() == 0) {
      return list;
    } else {
      List<Integer> low = new ArrayList<>();
      Integer mid = list.get(0);
      List<Integer> high = new ArrayList<>();
      for (Integer i : list.subList(1, list.size())) {
        if (i < mid) {
          low.add(i);
        } else {
          high.add(i);
        }
      }
      if (low != null) {
        sorted.addAll(sort(low));
      }
      sorted.add(mid);
      if (high != null) {
        sorted.addAll(sort(high));
      }
    }
    return sorted;
  }

}
