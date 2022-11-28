public class DictionaryTree {
  private DictionaryTreeNode overallRoot;
  
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

  public void printInOrder(int memberNumber){
    printInOrder(memberNumber, overallRoot);
  }

  private void printInOrder(int memberNumber, DictionaryTreeNode root){
    if(root != null){
      printInOrder(memberNumber, root.left);
      if(root.getEntry().getMemberNumber() == memberNumber){
        System.out.println(root);
      }
      printInOrder(memberNumber, root.right);
    }
  }

  public void printInOrder(String lastName){
    printInOrder(lastName, overallRoot);
  }

  private void printInOrder(String lastName, DictionaryTreeNode root){
    if(root != null){
      printInOrder(lastName, root.left);
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
      printInOrder(lastName, root.right);
    }
  }

  public void printPreOrder(String lastName){
    printPreOrder(lastName, overallRoot);
  }

  private void printPreOrder(String lastName, DictionaryTreeNode root){
    if(root != null){
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
      printPreOrder(lastName, root.left);
      printPreOrder(lastName, root.right);
    }
  }

  public void printPostOrder(String lastName){
    printPostOrder(lastName, overallRoot);
  }

  private void printPostOrder(String lastName, DictionaryTreeNode root){
    if(root != null){
      printPostOrder(lastName, root.left);
      printPostOrder(lastName, root.right);
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
    }
  }

  public DictionaryTreeNode getOverallRoot(){
    return overallRoot;
  }
}
