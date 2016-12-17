package org.app.spring.controller;

//import org.app.spring.model.Person;
import org.app.spring.entity.Person;
import org.app.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by meghad on 17/12/16.
 * using @Controller annotation, so that Spring framework will treat it as a Controller class to handle client requests.
 * Also using @Autowired and @Qualifier annotations for injecting PersonService,
 * we could have done it in the spring context xml file too
 */

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }

   /* @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }*/

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView listPersons(Model model) {
        ModelAndView modelAndView = new ModelAndView("person");
        modelAndView.addObject("person", new Person());
        modelAndView.addObject("listPersons", this.personService.listPersons());
        return modelAndView;
    }

    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){

        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }

        return "redirect:/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){

        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
}
