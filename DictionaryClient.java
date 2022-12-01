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
        //if dictionary is null, print error message
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          //remove entry from dictionary
          memberDictionary = removeMember(input, memberDictionary);
        }
      } else if(option.equals("s")){
        //if dictionary is null, print error message
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          //search dictionary
          searchMember(memberDictionary, input);
        }
      } else if(option.equals("m")){
        //if dictionary is null, print error message
        if(memberDictionary.getOverallRoot() == null){
          System.out.println("Sorry, there is nothing in the dictionary.");
        } else{
          //modify dictionary entry
          memberDictionary = modifyEntry(input, memberDictionary);
        }
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

  //accepts Scanner and DictionaryTree
  //prompts user for member number, then displays the located entry
  //confirms it should be removed, and returns DictionaryTree for removal
  public static DictionaryTree removeMember(Scanner input, DictionaryTree memberDictionary){
    String confirmation = "";
    int memberNumber;

    do{
      //prompt user for member number
      System.out.println("Enter member number: ");
      memberNumber = input.nextInt();

      //print out entry and prompt user for data confirmation
      System.out.println("\n");
      memberDictionary.printInOrder(memberNumber);
      System.out.println("\nShould this member data be removed? (y/n) ");
      confirmation = input.next().toLowerCase();

      //if confirmation is invalid, re-prompt user for confirmation
      while(!confirmation.equals("y") && !confirmation.equals("n")){
        System.out.println("Sorry, that input is invalid, please try again: ");
        confirmation = input.next().toLowerCase();
      }
    } while(!confirmation.equals("y")); //if user response is no, re-prompt for member data
    memberDictionary.remove(memberNumber);
    return memberDictionary;
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

  //accepts Scanner and DictionaryTree as input
  //prompts user for member number of entry they want to modify
  //confirms entry to modify then asks what fields should be changed
  //confirms changes to fields then deletes and adds entry back to the DictionaryTree
  //returns the DictionaryTree when entry has been modified
  public static DictionaryTree modifyEntry(Scanner input, DictionaryTree memberDictionary){
    String confirmation = "";
    int memberNumber;
    
    do{
      //prompt user for member number
      System.out.println("Enter member number: ");
      memberNumber = input.nextInt();

      //print out entry and prompt user for data confirmation
      System.out.println("\n");
      memberDictionary.printInOrder(memberNumber);
      System.out.println("\nShould this member data be modified? (y/n) ");
      confirmation = input.next().toLowerCase();

      //if confirmation is invalid, re-prompt user for confirmation
      while(!confirmation.equals("y") && !confirmation.equals("n")){
        System.out.println("Sorry, that input is invalid, please try again: ");
        confirmation = input.next().toLowerCase();
      }
    } while(!confirmation.equals("y")); //if user response is no, re-prompt for member data

    //create copy of the entry corresponding to the member number 
    DictionaryEntry entry = memberDictionary.fetchNode(memberNumber);

    confirmation = "";
    
    do{
      //list possible options
      System.out.println("\nWhich field would you like to modify?");
      System.out.println("\tModify member number: (n)");
      System.out.println("\tModify first name: (f)");
      System.out.println("\tModify last name: (l)");
      System.out.println("\tModify street address: (a)");
      System.out.println("\tModify city: (c)");
      System.out.println("\tModify state abbreviation: (s)");
      System.out.println("\tModify zipcode: (z)");
      System.out.println("\tModify email: (e)");
      System.out.println("\tModify phone number: (p)");

      System.out.println("\nEnter a command: ");
      String option = input.next().toLowerCase();

      switch(option){
        //this case is when they wish to change the member number
        case "n":
          System.out.println("\nThe current member number is " + entry.getMemberNumber());
          System.out.println("Enter new member number: ");
          entry.setMemberNumber(input.nextInt());
          break;
        //this case is when they wish to change the first name
        case "f":
          System.out.println("\nThe current first name is " + entry.getFirstName());
          System.out.println("Enter new first name: ");
          entry.setFirstName(input.next());
          break;
        //this case is when they wish to change the last name
        case "l":
          System.out.println("\nThe current last name is " + entry.getLastName());
          System.out.println("Enter new last name: ");
          entry.setLastName(input.next());
          break;
        //this case is when they wish to change the street address
        case "a":
          System.out.println("\nThe current street address is " + entry.getStreetAddress());
          System.out.println("Enter new street address: ");
          entry.setStreetAddress(input.nextLine());
          break;
        //this case is when they want to change the city
        case "c":
          System.out.println("\nThe current city is " + entry.getCity());
          System.out.println("Enter new city: ");
          entry.setCity(input.next());
          break;
        //this case is when they want to change the state abbreviation
        case "s":
          System.out.println("\nThe current state abbreviation is " + entry.getState());
          System.out.println("Enter new state abbreviation: ");
          entry.setState(input.next());
          break;
        //this case is when they want to change the zip code
        case "z":
          System.out.println("\nThe current zip code is " + entry.getZipcode());
          System.out.println("Enter new zip code: ");
          entry.setZipcode(input.nextInt());
          break;
        //this case is when they want to change the email
        case "e":
          System.out.println("\nThe current email is " + entry.getEmail());
          System.out.println("Enter new email: ");
          entry.setEmail(input.next());
          break;
        //this case is when they want to change the phone number
        case "p":
          System.out.println("\nThe current phone number is " + entry.getPhoneNumber());
          System.out.println("Enter new phone number: ");
          entry.setPhoneNumber(input.next());
          break;
        default:
          System.out.println("\nSorry, that input is invalid, please try again: ");
          continue;
      }

      System.out.println("\nThe new entry is: \n\n" + entry + "\nIs this correct?");
      confirmation = input.next().toLowerCase();

      //if confirmation is invalid, re-prompt user for confirmation
      while(!confirmation.equals("y") && !confirmation.equals("n")){
        System.out.println("Sorry, that input is invalid, please try again: ");
        confirmation = input.next().toLowerCase();
      }
    } while(!confirmation.equals("y")); //if user response is no, re-prompt for member data

    //remove old entry from tree then add the new entry
    //this is done in case the member number is changed the tree would be unsorted
    memberDictionary.remove(memberNumber);
    memberDictionary.add(entry);

    return memberDictionary;
  }
}
