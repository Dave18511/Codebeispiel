import BinTree;
import Utilities;
import java.util.HashMap;

public class HuffmanCodeBaum {

  public static BinTree codeTree(String text) {

    //Häufigkeiten zählen O(n * log n), vergrößern der Hashmap
    HashMap<Character, Integer> occurences = new HashMap<Character, Integer>();
    for (int i = 0; i < text.length(); i++) {
      occurences.put(text.charAt(i), occurences.getOrDefault(text.charAt(i), 0) + 1);
    }

    // Liste von bäumen bauen die mit Radixsort sortiert wird O(n)
    MyBinTree[] trees = new MyBinTree[occurences.size()];
    int i = 0;
    int maxPos = 0;
    for (Character c : occurences.keySet()) {
      trees[i] = new MyBinTree(new BinTree(c, null, null), occurences.get(c));
      if (trees[maxPos].getOccurences() < trees[i].getOccurences()) {
        maxPos = i;
      }
      i++;
    }
    Utilities.RadixSortTree(trees, trees[maxPos].getOccurences());

    // die seltensten Zeichen zusammenfügen, ähnlich zu Insertionsort O(n * n)
    int l = 0, r = trees.length - 1;
    while (l < r) {
      trees[l + 1] = new MyBinTree(new BinTree(null, trees[l].getTree(), trees[l + 1].getTree()),
          trees[l].getOccurences() + trees[l + 1].getOccurences());
      for (i = l + 2; i < trees.length; i++) {
        if (trees[i - 1].getOccurences() > trees[i].getOccurences()) {
          swap(trees, i, i - 1);
        } else {
          break;
        }
      }
      l++;
    }

    return trees[trees.length - 1].getTree();
  }

  private static void swap(MyBinTree[] a, int l, int r) {
    MyBinTree h = a[l];
    a[l] = a[r];
    a[r] = h;
  }

  // val von BinTree benutzen..
  public static class MyBinTree {

    private BinTree tree;
    private int occurences;

    public MyBinTree(BinTree tree, int occurences) {
      this.tree = tree;
      this.occurences = occurences;
    }

    public BinTree getTree() {
      return tree;
    }

    public int getOccurences() {
      return occurences;
    }

    public void setOccurences(int occurences) {
      this.occurences = occurences;
    }
  }

  public static String decode(boolean encoded[], BinTree code) {
    if (encoded == null || encoded.length == 0 || code == null) {
      return null;
    }
    BinTree root = code;
    StringBuilder s = new StringBuilder();
    int i = 0;
    while (i < encoded.length) {
      while (!code.isleaf()) {
        if (encoded[i]) {
          code = code.rson();
        } else {
          code = code.lson();
        }
        i++;
      }
      s.append(code.val());
      code = root;
    }
    return s.toString();
  }

  public static void main(String args[]) {
    codeTree("Hallo");
    BinTree code = new BinTree(null, new BinTree(null,
        new BinTree(null, new BinTree('H', null, null), new BinTree('a', null, null)),
        new BinTree('o', null, null)), new BinTree('l', null, null));
    boolean[] encoded = new boolean[10];
    encoded[0] = false;
    encoded[1] = false;
    encoded[2] = false;
    encoded[3] = false;
    encoded[4] = false;
    encoded[5] = true;
    encoded[6] = true;
    encoded[7] = true;
    encoded[8] = false;
    encoded[9] = true;
    System.out.println(decode(encoded, code));
  }
}
