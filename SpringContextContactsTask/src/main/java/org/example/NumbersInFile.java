package org.example;

import org.springframework.stereotype.Component;
import java.io.*;
@Component
public class NumbersInFile {
    public void addContactsToFile(String name, String number, String email) throws IOException {
        if (name.matches("[a-zA-Z]+") && number.matches("[0-9]{2}") && email.endsWith("@mail.ru")) {
            String contact = name + ";" + number + ";" + email + ";";

            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/resources/default-contacts"),true));
            writer.write(contact + "\n");

            writer.close();
        } else {
            System.out.println("Something wrong");
        }

    }

}
