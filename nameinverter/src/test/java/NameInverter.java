import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NameInverter {

  private String name;

  private String getPostNominal(List<String> names) {
    StringBuilder sb = new StringBuilder();
    for (String string : names.subList(2, names.size())) {
      sb.append(string);
      sb.append(" ");
    }
    return sb.toString();
  }

  private boolean isHonorific(List<String> names) {
    return names.get(0).matches("Mr\\.|Mrs\\.");
  }

  public String invert(String name) {
    this.name = name;
    if (name == null || name.isEmpty()) {
      return "";
    } else {

      List<String> names;
      names = removeHonorific(splitNames(name));
      if (names.size() == 1) {
        return names.get(0);
      }
      return formatMultiElementName(names);
    }
  }

  private List<String> removeHonorific(List<String> names) {
    if (names.size() > 1 && isHonorific(names)) {
      names.remove(0);
    }
    return names;
  }

  private ArrayList<String> splitNames(String name) {
    return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
  }

  private String formatMultiElementName(List<String> names) {
    String postNominal = "";
    if (names.size() > 2) {
      postNominal = getPostNominal(names);
    }
    return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
  }
}
