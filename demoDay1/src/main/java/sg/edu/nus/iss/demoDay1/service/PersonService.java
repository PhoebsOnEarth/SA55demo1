package sg.edu.nus.iss.demoDay1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.demoDay1.model.Person;

@Service
public class PersonService {
    private List<Person>  persons = new ArrayList<Person>();

    public PersonService(){
        persons.add(new Person("Mark", "Kwan"));
        persons.add(new Person("Daryl", "Eddie"));
    }

    // Read
    public List<Person> getPersons(){
        return this.persons;
    }

    // Create
    public void addPerson(Person newPerson){
        this.persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    // delete
    public void removePerson(Person personToDelete){
        Person foundPerson = persons.stream()
        .filter(
            p -> p.getId()
                .equals(personToDelete.getId())
            )
        .findAny().orElse(null);
        persons.remove(foundPerson);
    }

    // update
    public void updatePerson(Person personToUpdate){
        Person foundPerson = persons.stream()
            .filter(
                p->p.getId()
                    .equals(personToUpdate.getId())
                    )
                .findAny()
                .orElse(null);
        
        Person updatePerson = new Person();
        updatePerson.setId(personToUpdate.getId());
        updatePerson.setFirstName(personToUpdate.getFirstName());
        updatePerson.setLastName(personToUpdate.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);

    }


}
