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
    return "Member number: " + entry.getMemberNumber() + "\n\t" + entry.getFirstName() +
      " " + entry.getLastName() + "\n\t" + entry.getStreetAddress() + "\n\t" + entry.getCity() +
      ", " + entry.getState() + "    " + entry.getZipcode() + "\n\t" + entry.getEmail() + "\n\t" +
      entry.getPhoneNumber() + "\n";
  }
}
