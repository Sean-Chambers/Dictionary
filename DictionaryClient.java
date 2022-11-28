import java.util.*;

public class DictionaryClient {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    String option = "";
    DictionaryTree memberDictionary = new DictionaryTree();

    intro();
    menu();

    do{
      System.out.println("\nEnter a command: ");
      option = input.next().toLowerCase();
      if(option.equals("a")){
        memberDictionary.add(createMember(input));
      } else if(option.equals("r")){
        System.out.println("remove"); //TODO create remove method
      } else if(option.equals("s")){
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          searchMember(memberDictionary, input);
        }
      } else if(option.equals("m")){
        System.out.println("modify"); //TODO create modify method
      } else if(option.equals("p")){
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          memberDictionary.print();
        }
      } else if(option.equals("o")){
        menu();
      } else if(option.equals("e")){
        outro();
      } else{
        System.out.println("Sorry, that input is invalid. Please try again.");
      }
    } while(!option.equals("e"));
    input.close();
  }

  public static void intro(){
    System.out.println("intro\n");
  }

  public static void menu(){
    System.out.println("Enter a letter to select an option below: ");
    System.out.println("-Add an entry (a)");
    System.out.println("-Remove an entry (r)");
    System.out.println("-Search for an entry (s)");
    System.out.println("-Modify an entry (m)");
    System.out.println("-Print the dictionary (p)");
    System.out.println("-Print the options menu (o)");
    System.out.println("-Exit the program (e)");
  }

  public static DictionaryEntry createMember(Scanner input){
    DictionaryEntry entry = new DictionaryEntry();
    String confirmation = "";

    do{
      System.out.println("Enter member number: ");
      entry.setMemberNumber(input.nextInt());
      System.out.println("Enter first name: ");
      entry.setFirstName(input.next());
      System.out.println("Enter last name: ");
      entry.setLastName(input.next());
      System.out.println("Enter street address: ");
      input.nextLine();
      entry.setStreetAddress(input.nextLine());
      System.out.println("Enter city: ");
      entry.setCity(input.next());
      System.out.println("Enter state abbreviation: ");
      entry.setState(input.next());
      System.out.println("Enter zipcode: ");
      entry.setZipcode(input.nextInt());
      System.out.println("Enter email: ");
      entry.setEmail(input.next());
      System.out.println("Enter phone number: ");
      entry.setPhoneNumber(input.next());

      System.out.println("\n" + entry);
      System.out.println("\nIs this member data correct? (y/n) ");
      confirmation = input.next().toLowerCase();

      while(!confirmation.equals("y") && !confirmation.equals("n")){
        System.out.println("Sorry, that input is invalid, please try again: ");
        confirmation = input.next().toLowerCase();
      }
    } while(!confirmation.equals("y"));

    return entry;
  }

  public static void outro(){
    System.out.println("outro");
  }

  public static void searchMember(DictionaryTree memberDictionary, Scanner input){
    System.out.println("Would you like to search by member number (1) or by last name (2)? ");
    String option = input.next().toLowerCase();

    while(!option.equals("1") && !option.equals("2")){
      System.out.println("Sorry, that isn't an available option, please try again: ");
      option = input.next().toLowerCase();
    }

    if(option.equals("1")){
      System.out.println("Please enter the member number: ");
      int memberNumber = input.nextInt();
      System.out.println("\nSearch results: ");
      memberDictionary.printInOrder(memberNumber);
    } else{
      System.out.println("Please enter the last name: ");
      String lastName = input.next();
      System.out.println("Would you like to do pre-order (1), in-order (2), or post-order (3) searches? ");
      option = input.next().toLowerCase();

      while(!option.equals("1") && !option.equals("2") && !option.equals("3")){
        System.out.println("Sorry, that isn't an available option, please try again: ");
        option = input.next().toLowerCase();
      }

      System.out.println("\nSearch results: ");
      if(option.equals("1")){
        memberDictionary.printPreOrder(lastName);
      } else if(option.equals("2")){
        memberDictionary.printInOrder(lastName);
      } else{
        memberDictionary.printPostOrder(lastName);
      }
    }
  }
}
