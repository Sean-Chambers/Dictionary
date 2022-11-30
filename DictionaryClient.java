//Sarah Hoekema and Sean Chambers
//CS 145
//December 6, 2022
//Lab 6 - Dictionary

import java.util.*;

//DictionaryClient.java allows a user to interact with a member list by adding, removing
//searching for, and modifying entries, as well as print the entire member dictionary.
public class DictionaryClient {
  public static void main(String[] args){
    //construct Scanner and DictionaryTree
    Scanner input = new Scanner(System.in);
    DictionaryTree memberDictionary = new DictionaryTree();
    String option = "";

    intro();
    menu();

    do{
      //prompt user for an option
      System.out.println("\nEnter a command: ");
      option = input.next().toLowerCase();

      if(option.equals("a")){
        //add entry to dictionary
        memberDictionary.add(createMember(input));
      } else if(option.equals("r")){
        //remove entry from dictionary
        System.out.println("remove"); //TODO create remove method
      } else if(option.equals("s")){
        //if dictionary is null, print error message
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          //search dictionary
          searchMember(memberDictionary, input);
        }
      } else if(option.equals("m")){
        //modify dictionary entry
        System.out.println("modify"); //TODO create modify method
      } else if(option.equals("p")){
        //if dictionary is null, print error message
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          //print dictionary
          memberDictionary.print();
        }
      } else if(option.equals("o")){
        //print options menu
        menu();
      } else if(option.equals("e")){
        //print outro message
        outro();
      } else{
        //if option is invalid, print error message
        System.out.println("Sorry, that input is invalid. Please try again.");
      }
    } while(!option.equals("e"));
    //close Scanner
    input.close();
  }

  //print an introduction to the dictionary
  public static void intro(){
    System.out.println("Welcome to the member dictionary."); 
    System.out.print("The member dictionary can be used to sort and search various ");
    System.out.println("entries for different members.");
    System.out.println("Please view the menu below to get started.\n");
  }

  //print the menu for the dictionary
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

  //print outro for the dictionary
  public static void outro(){
    System.out.println("Thank you for using the member dictionary.");
    System.out.println("Come back soon!");
  }

  //accept Scanner for input
  //prompt the user for member data, print out entry for confirmation, and 
  //return a DictionaryEntry entry when confirmed
  public static DictionaryEntry createMember(Scanner input){
    DictionaryEntry entry = new DictionaryEntry();
    String confirmation = "";

    //prompt user for member data and add to entry
    do{ //TODO figure out reading in line input
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

      //print out entry and prompt user for data confirmation
      System.out.println("\n" + entry);
      System.out.println("\nIs this member data correct? (y/n) ");
      confirmation = input.next().toLowerCase();

      //if confirmation is invalid, re-prompt user for confirmation
      while(!confirmation.equals("y") && !confirmation.equals("n")){
        System.out.println("Sorry, that input is invalid, please try again: ");
        confirmation = input.next().toLowerCase();
      }
    } while(!confirmation.equals("y")); //if user response is no, re-prompt for member data
    return entry;
  }

  //accept DictionaryTree for member dictionary and Scanner for input
  //prompt user for search type and necessary information, then prints the search results
  public static void searchMember(DictionaryTree memberDictionary, Scanner input){
    //prompt for search type
    System.out.println("Would you like to search by member number (1) or by last name (2)? ");
    String option = input.next().toLowerCase();

    //if option is invalid, re-prompt user for option
    while(!option.equals("1") && !option.equals("2")){
      System.out.println("Sorry, that isn't an available option, please try again: ");
      option = input.next().toLowerCase();
    }

    if(option.equals("1")){
      //prompt user for member number, the print results
      System.out.println("Please enter the member number: ");
      int memberNumber = input.nextInt();
      System.out.println("\nSearch results: ");
      memberDictionary.printInOrder(memberNumber);
    } else{
      //prompt user for last name
      System.out.println("Please enter the last name: ");
      String lastName = input.next();
      //prompt user for search type
      System.out.print("Would you like to do pre-order (1), in-order (2), or ");
      System.out.println("post-order (3) searches? ");
      option = input.next().toLowerCase();

      //if option is invalid, re-prompt user for option
      while(!option.equals("1") && !option.equals("2") && !option.equals("3")){
        System.out.println("Sorry, that isn't an available option, please try again: ");
        option = input.next().toLowerCase();
      }

      //print search results
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
