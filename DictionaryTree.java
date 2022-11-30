//Sarah Hoekema and Sean Chambers
//CS 145
//December 6, 2022
//Lab 6 - Dictionary

//DictionaryTree.java represents a sorted binary tree member dictionary of member entry nodes, each of which contain biographical details and a unique member number.
public class DictionaryTree {
  //field
  private DictionaryTreeNode overallRoot;
  
  //constructors
  DictionaryTree(DictionaryTreeNode overallRoot){
    this.overallRoot = overallRoot;
  }

  DictionaryTree(){
    this(null);
  }

  //accept an DictionaryEntry for an entry
  //public method to add entry to tree
  public void add(DictionaryEntry entry){
    //call private method
    overallRoot = add(entry, overallRoot);
  }

  //accept a DictionaryEntry for an entry and a DictionaryTreeNode for the root
  //private recursive method to add entry to tree
  private DictionaryTreeNode add(DictionaryEntry entry, DictionaryTreeNode root){
    if(root == null){
      //add root to tree when root is null
      root = new DictionaryTreeNode(entry);
    } else if(root.getEntry().getMemberNumber() >= entry.getMemberNumber()){
      //moves to the left subtree if the root member number is greater than the entry
      //member number
      root.left = add(entry, root.left);
    } else if(root.getEntry().getMemberNumber() < entry.getMemberNumber()){
      //moves to the right subtree if the root member number is less than the entry
      //member number
      root.right = add(entry, root.right);
    }
    return root;
  }

  //public method to print the dictionary tree
  public void print(){
    //call private method
    print(overallRoot);
  }

  //accept a DictionaryTreeNode for the root
  //private recursive method to print the dictionary tree
  private void print(DictionaryTreeNode root){
    //print the in-order sorted version of the dictionary tree
    if(root != null){
      print(root.left);
      System.out.println(root);
      print(root.right);
    }
  }

  //accept an int for a member number
  //public method for printing in order
  public void printInOrder(int memberNumber){
    //call private method
    printInOrder(memberNumber, overallRoot);
  }

  //accept an int for a member number and a DictionaryTreeNode for a root
  //private method for printing in order
  private void printInOrder(int memberNumber, DictionaryTreeNode root){
    //in order traversal through the tree
    if(root != null){
      printInOrder(memberNumber, root.left);
      //print entry if equal to the provided member number
      if(root.getEntry().getMemberNumber() == memberNumber){
        System.out.println(root);
      }
      printInOrder(memberNumber, root.right);
    }
  }

  //accept a String for a last name
  //public method for printing in order
  public void printInOrder(String lastName){
    //call private method
    printInOrder(lastName, overallRoot);
  }

  //accept a String for a last name and a DictionaryTreeNode for a root
  //private method for printing in order
  private void printInOrder(String lastName, DictionaryTreeNode root){
    //in order traversal through tree
    if(root != null){
      printInOrder(lastName, root.left);
      //print entry if equal to the provided last name
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
      printInOrder(lastName, root.right);
    }
  }

  //accept a String for a last name
  //public method for printing pre order
  public void printPreOrder(String lastName){
    //call private method
    printPreOrder(lastName, overallRoot);
  }

  //accept a String for a last name and a DictionaryTreeNode for a root
  //private method for printing pre order
  private void printPreOrder(String lastName, DictionaryTreeNode root){
    //pre order traversal through tree
    if(root != null){
      //print entry if equal to the provided last name
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
      printPreOrder(lastName, root.left);
      printPreOrder(lastName, root.right);
    }
  }

  //accept a String for a last name
  //public method for printing post order
  public void printPostOrder(String lastName){
    //call private method
    printPostOrder(lastName, overallRoot);
  }

  //accept a String for a last name and a DictionaryTreeNode for a root
  //private method for printing post order
  private void printPostOrder(String lastName, DictionaryTreeNode root){
    //pre order traversal through tree
    if(root != null){
      printPostOrder(lastName, root.left);
      printPostOrder(lastName, root.right);
      //print entry if equal to the provided last name
      if(root.getEntry().getLastName().equals(lastName)){
        System.out.println(root);
      }
    }
  }

  //get the overallRoot of the dictionary tree
  public DictionaryTreeNode getOverallRoot(){
    return overallRoot;
  }
}
