//Sarah Hoekema and Sean Chambers
//CS 145
//December 6, 2022
//Lab 6 - Dictionary


//DictionaryEntry.java represents a single member entry and contains the data about
//that member
public class DictionaryEntry {
  //fields
  private String firstName;
  private String lastName;
  private String streetAddress;
  private String city;
  private String state;
  private int zipcode;
  private String email;
  private String phoneNumber;
  private int memberNumber;

  //constructors
  public DictionaryEntry(String firstName, String lastName, String streetAddress,
      String city, String state, int zipcode, String email, String phoneNumber,
      int memberNumber){
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.memberNumber = memberNumber;
  }

  public DictionaryEntry(){
    this(null, null, null, null, null, 0, null, null, 0);
  }

  //set the first name of the entry
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  //set the last name of the entry
  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  //set the street address of the entry
  public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
  }

  //set the city of the entry
  public void setCity(String city){
    this.city = city;
  }

  //set the state of the entry
  public void setState(String state){
    this.state = state;
  }

  //set the zipcode of the entry
  public void setZipcode(int zipcode){
    this.zipcode = zipcode;
  }

  //set the email of the entry
  public void setEmail(String email){
    this.email = email;
  }

  //set the phone number of the entry
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  //set the member number of the entry
  public void setMemberNumber(int memberNumber){
    this.memberNumber = memberNumber;
  }

  //get the first name of the entry
  public String getFirstName(){
    return firstName;
  }

  //get the last name of the entry
  public String getLastName(){
    return lastName;
  }

  //get the street address of the entry
  public String getStreetAddress(){
    return streetAddress;
  }

  //get the city of the entry
  public String getCity(){
    return city;
  }

  //get the state of the entry
  public String getState(){
    return state;
  }

  //get the zipcode of the entry
  public int getZipcode(){
    return zipcode;
  }

  //get the email of the entry
  public String getEmail(){
    return email;
  }

  //get the phone number of the entry
  public String getPhoneNumber(){
    return phoneNumber;
  }

  //get the member number of the entry
  public int getMemberNumber(){
    return memberNumber;
  }

  //return a String representation of the entry
  public String toString(){
    return "Member number: " + memberNumber + "\n\t" + firstName +
      " " + lastName + "\n\t" + streetAddress + "\n\t" + city +
      ", " + state + "    " + zipcode + "\n\t" + email + "\n\t" +
      phoneNumber + "\n";
  }
}
