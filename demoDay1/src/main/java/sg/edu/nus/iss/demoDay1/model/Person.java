package sg.edu.nus.iss.demoDay1.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Person {
    private String id;
    private String firstName;
    private String lastName;

    public Person(){
        this.id = UUID.randomUUID().toString().substring(0, 10);
    }

    public Person(String firstName,String lastName){
        this.id = UUID.randomUUID().toString().substring(0, 10);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
