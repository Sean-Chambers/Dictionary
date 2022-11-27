public class DictionaryTreeNode {
  DictionaryEntry entry;
  DictionaryTreeNode left;
  DictionaryTreeNode right;

  public DictionaryTreeNode(DictionaryEntry entry){
    this(entry, null, null);
  }

  public DictionaryTreeNode(DictionaryEntry entry, DictionaryTreeNode left,
      DictionaryTreeNode right){
    this.entry = entry;
    this.left = left;
    this.right = right;
  }

  public String toString(){
    return entry.toString();
  }
}
