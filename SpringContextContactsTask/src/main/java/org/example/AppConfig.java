package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public Contact contact(){
        return new Contact();
    }
    @Bean
    public NumbersInFile numbersInFile(){
        return new NumbersInFile();
    }
}
