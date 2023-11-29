package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Contact> contactsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NumbersInFile numbersInFile = context.getBean(NumbersInFile.class);
        Contact contact = context.getBean(Contact.class);
        while(true) {
            System.out.println("1 - Add contact");
            System.out.println("2 - Remove contact");
            System.out.println("3 - Show all contacts");
            int userChoose = new Scanner(System.in).nextInt();
            if (userChoose == 1) {
                System.out.println("Name : ");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Number : ");
                String number = new Scanner(System.in).nextLine();
                System.out.println("Email : ");
                String email = new Scanner(System.in).nextLine();

                contact.AddContact(name, number, email);
                numbersInFile.addContactsToFile(name, number, email);
            }
            if(userChoose == 2){
                System.out.println("Email for remove : ");
                String emailRemove = new Scanner(System.in).nextLine();
                contact.RemoveContactFromList(emailRemove);
            }

            if(userChoose == 3){
                contact.ShowAllContactsInList();
            }
        }
    }
}