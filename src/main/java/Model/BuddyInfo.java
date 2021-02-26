package Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {
    public String name;
    public String phoneNumber;
    public String address;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private AddressBook AddressBook;

    public BuddyInfo() {}

    //creates a buddy with a name and a number
    public BuddyInfo(String name, String number, AddressBook ab,String address){
        this.name = name;
        phoneNumber = number;
        AddressBook = ab;
        this.address = address;
    }

    public Long getId() {

        return id;
    }

    //sets the name
    public void setName(String name){

        this.name = name;
    }

    //sets the name
    public String getName(){
        return name;
    }

    //returns the number
    public String getPhoneNumber(){
        return phoneNumber;
    }

    //set the address
    public void setAddress(String address){
        this.address = address;
    }

    //returns the number
    public String getAddress(){
        return address;
    }

    //sets the number
    public void setPhoneNumber(String phoneNumber){

        this.phoneNumber = phoneNumber;
    }

    public AddressBook getAddressBook() {
        return AddressBook;
    }

    public void setAddressBook() {
        this.AddressBook = AddressBook;
    }

    @Override
    public String toString() {
        return String.format(
                "Buddy [id=%d, name='%s', phoneNumber='%s']",
                id, name, phoneNumber);
    }

}
