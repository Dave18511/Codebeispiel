
import MyBinTree;
import java.awt.Point;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Utilities {

  public static void RadixSortTree(MyBinTree[] a, int max) {
    int k = 0;
    while (max > 0) {
      max /= 2;
      k++;
    }
    for (int i = 0; i < k; i++) {
      sortTree(a, i);
    }
  }

  private static void sortTree(MyBinTree[] values, int k) {
    int mask = 0x00000001 << k;
    int insertIndex = 0;
    ArrayList<MyBinTree> big = new ArrayList<>();
    for (int i = 0; i < values.length; ++i) {
      if ((values[i].getOccurences() & mask) == 0) {
        values[insertIndex++] = values[i];
      } else {
        big.add(values[i]);
      }
    }
    for (int i = 0; i < big.size(); ++i) {
      values[insertIndex++] = big.get(i);
    }
  }
}
