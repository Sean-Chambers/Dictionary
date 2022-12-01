//Sarah Hoekema and Sean Chambers
//CS 145
//December 6, 2022
//Lab 6 - Dictionary

//DictionaryTree.java represents a sorted binary tree member dictionary of member entry nodes,
//each of which contain biographical details and a unique member number.
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

  //accept a member number for removal 
  //public method to remove entry from tree
  public void remove(int target){
    //call private method
    overallRoot = remove(target, overallRoot);
  }

  //accepts an int and a DictionaryTreeNode
  //int represents the member number and the DictionaryTreeNode is the root
  //private method to remove entry from tree
  private DictionaryTreeNode remove(int target, DictionaryTreeNode root){
    if(root == null){
      //tree already doesn't contain member number
      return root;
    }else if(target < root.getEntry().getMemberNumber()){
      //target should be on left side
      //set left node to node returned by recursive remove call
      root.left = remove(target,root.left);
    }else if (target > root.getEntry().getMemberNumber()){
      //target should be on right side
      //set left node to node returned by recursive remove call
      root.right = remove(target,root.right);
    }else{
      //in this case the current node is the target
      if(root.right == null && root.left == null){
        //target is a leaf node, no need to handle children
        //return null object to remove pointer
        return null;
      }else if(root.left == null){
        //target leaf only has a right child
        //right child is its own binary search tree, no need to reorder
        //set right node to replace current node
        root = root.right;
      }else if(root.right == null){
        //target leaf only has a left child
        //left child is its own binary search tree, no need to reorder
        //set left node to replace current node
        root = root.left;
      }else{
        //target has both left and right children
        //set temp node to entry with smallest member number in right subtree
        DictionaryEntry min = minValue(root.right);
        DictionaryTreeNode temp = new DictionaryTreeNode(min);
        //set temp node's left child to root's left child
        temp.left = root.left;
        //set temp node's right child to right node without the small value node
        //this requires calling remove again to remove the moved node
        temp.right = remove(min.getMemberNumber(), root.right);
        //set root equal to temp
        root = temp;
      }
    }
    //return the modified root
    return root;
  }

  //finds entry that contains the smallest member number in a subtree
  //this method is used in remove when the removed node has 2 children
  private DictionaryEntry minValue(DictionaryTreeNode root){
    //checks if root has a left subtree, if not then root contains smallest value
    return (root.left == null) ? root.getEntry() : minValue(root.left);
  }

  //public method that finds and returns entry coreesponding to a member number
  public DictionaryEntry fetchNode(int memberNumber){
    //calls private method
    return fetchNode(memberNumber, overallRoot);
  }

  //private method that finds and returns entry corresponding to a member number
  private DictionaryEntry fetchNode(int memberNumber, DictionaryTreeNode root){
    if(root.getEntry().getMemberNumber() == memberNumber){
      //base case, member number found
      return root.getEntry();
    }else if(root.getEntry().getMemberNumber() < memberNumber){
      //member number is in right subtree
      return fetchNode(memberNumber, root.right);
    }else{
      //member number is in left subtree
      return fetchNode(memberNumber, root.left);
    }
  }
}
