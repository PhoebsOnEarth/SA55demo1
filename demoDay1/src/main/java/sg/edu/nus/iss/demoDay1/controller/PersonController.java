package sg.edu.nus.iss.demoDay1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.demoDay1.model.Person;
import sg.edu.nus.iss.demoDay1.service.PersonService;


@Controller
@RequestMapping("persons")
public class PersonController {

    private List<Person> personList = new ArrayList<Person>();

    @Autowired
    PersonService personService;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${person.list.header}") 
    private String headerMessage; 

    @GetMapping(value = {"/index", "/home","/"})
    public String index(Model model){
        model.addAttribute("message", welcomeMessage);
        return "home";
        
    }

    @GetMapping(value = "/testsRetrieveAllPerson", produces = "application/json")
    public @ResponseBody List<Person> getAllPersons(){
        personList = personService.getPersons();
        return personList;
    }

    @GetMapping(value = "/list")
    public String personList(Model theModel){
        personList = personService.getPersons();
        theModel.addAttribute("persons", personList);
        theModel.addAttribute("listofPersons",headerMessage);
        
        return "personList";
    }

    @GetMapping(value="/update")
    public String updatePerson(@ModelAttribute(value = "per") Person p, Model theModel){
        theModel.addAttribute("per", p);
        return "personEdit";
    }

    @PostMapping(value="/update")
    public String updatePersonRecord(@ModelAttribute(value = "person")Person p, Model theModel){
        personService.updatePerson(p);
        return "redirect:/persons/list";
    }



}
