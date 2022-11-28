public class DictionaryTree {
  DictionaryTreeNode overallRoot;
  
  DictionaryTree(DictionaryTreeNode overallRoot){
    this.overallRoot = overallRoot;
  }

  DictionaryTree(){
    this(null);
  }

  public void add(DictionaryEntry entry){
    overallRoot = add(entry, overallRoot);
  }

  private DictionaryTreeNode add(DictionaryEntry entry, DictionaryTreeNode root){
    if(root == null){
      root = new DictionaryTreeNode(entry);
    } else if(root.getEntry().getMemberNumber() >= entry.getMemberNumber()){
      root.left = add(entry, root.left);
    } else if(root.getEntry().getMemberNumber() < entry.getMemberNumber()){
      root.right = add(entry, root.right);
    }
    return root;
  }

  public void print(){
    print(overallRoot);
  }

  private void print(DictionaryTreeNode root){
    if(root != null){
      print(root.left);
      System.out.println(root);
      print(root.right);
    }
  }
}
