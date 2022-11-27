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
        //memberDictionary.add(createMember(input));
        System.out.println(new DictionaryTreeNode(createMember(input)));
      } else if(option.equals("r")){
        System.out.println("remove");
      } else if(option.equals("s")){
        System.out.println("search");
      } else if(option.equals("m")){
        System.out.println("modify");
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
      System.out.println("Enter state: ");
      entry.setState(input.next());
      System.out.println("Enter zipcode: ");
      entry.setZipcode(input.nextInt());
      System.out.println("Enter email: ");
      entry.setEmail(input.next());
      System.out.println("Enter phone number: ");
      input.nextLine();
      entry.setPhoneNumber(input.nextLine());
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
}
