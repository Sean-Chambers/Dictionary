//Sarah Hoekema and Sean Chambers
//CS 145
//December 6, 2022
//Lab 6 - Dictionary

//DictionaryTreeNode.java represents a single binary tree node and contains the 
//entry data for a member
public class DictionaryTreeNode {
  //fields
  DictionaryEntry entry;
  DictionaryTreeNode left;
  DictionaryTreeNode right;

  //constructors
  public DictionaryTreeNode(DictionaryEntry entry){
    this(entry, null, null);
  }

  public DictionaryTreeNode(DictionaryEntry entry, DictionaryTreeNode left,
      DictionaryTreeNode right){
    this.entry = entry;
    this.left = left;
    this.right = right;
  }

  //return the entry
  public DictionaryEntry getEntry(){
    return entry;
  }

  //return a String representation of the node
  public String toString(){
    return entry.toString();
  }
}
