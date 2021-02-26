package Model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class AddressBook implements Serializable {

    @Id
    private Long id =  Long.valueOf(0);
    @OneToMany(mappedBy = "AddressBook")
    public Set<BuddyInfo> buddies;
    private String name;

    public  AddressBook(){
        buddies = new HashSet();
    }

    //print all your buddies name then number
    private void listBuddies(){
        for(BuddyInfo x : buddies){
            System.out.print(x.getName() + "  ");
            System.out.println(x.getPhoneNumber());
        }
    }

    public Set<BuddyInfo> getBuddies() {
        return buddies;
    }
    public void setBuddies(Set<BuddyInfo> buddies) {
        this.buddies = buddies;
    }


    public Long getId(Long id) {
        return id;
    }

    public void addBuddy(BuddyInfo b){
        buddies.add(b);
    }

    //sets the name
    public void setName(String name){

        this.name = name;
    }

    //returns the name
    public String getName(){
        return name;
    }

}
