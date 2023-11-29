package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {
    private String name;
    private String number;
    private String email;
    public Contact(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void AddContact(String name, String number, String email){
        if (name.matches("[a-zA-Z]+") && number.matches("[0-9]{2}") && email.endsWith("@mail.ru")) {
            Main.contactsList.add(new Contact(name, number, email));
            System.out.println("Contact is added");
        } else {
            System.out.println("Something wrong");
        }
    }
    public void RemoveContactFromList(String email){
        for(int i = 0; i < Main.contactsList.size(); i++){
            if(Main.contactsList.get(i).getEmail().equals(email)){
                Main.contactsList.remove(Main.contactsList.get(i));
                System.out.println("Contact is deleted");
                continue;
            }
            if(i == Main.contactsList.size() - 1){
                System.out.println("Contact not found");
            }
        }
    }
    public void ShowAllContactsInList(){
        if(Main.contactsList.isEmpty()){
            System.out.println("There is no contacts yet");
        }
        for(Contact contact : Main.contactsList){
            System.out.println(contact.toString());
        }
    }

    public String toString(){
        return name + ";+" + number + ";" + email;
    }
}
