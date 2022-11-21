public class DictionaryEntry {
  private String firstName;
  private String lastName;
  private String streetAddress;
  private String city;
  private String state;
  private int zipcode;
  private String email;
  private String phoneNumber;
  private int memberNumber;

  public DictionaryEntry(String firstName, String lastName, String streetAddress,
    String city, String state, int zipcode, String email, String phoneNumber, int memberNumber){
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

    public void setFirstName(String firstName){
      this.firstName = firstName;
    }

    public void setLastName(String lastName){
      this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress){
      this.streetAddress = streetAddress;
    }

    public void setCity(String city){
      this.city = city;
    }

    public void setState(String state){
      this.state = state;
    }

    public void setZipcode(int zipcode){
      this.zipcode = zipcode;
    }

    public void setEmail(String email){
      this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
      this.phoneNumber = phoneNumber;
    }

    public void setMemberNumber(int memberNumber){
      this.memberNumber = memberNumber;
    }

    public String getFirstName(){
      return firstName;
    }

    public String getLastName(){
      return lastName;
    }

    public String getStreetAddress(){
      return streetAddress;
    }

    public String getCity(){
      return city;
    }

    public String getState(){
      return state;
    }

    public int getZipcode(){
      return zipcode;
    }

    public String getEmail(){
      return email;
    }

    public String getPhoneNumber(){
      return phoneNumber;
    }

    public int getMemberNumber(){
      return memberNumber;
    }
}
