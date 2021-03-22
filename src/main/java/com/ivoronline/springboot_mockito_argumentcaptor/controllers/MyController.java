package com.ivoronline.springboot_mockito_argumentcaptor.controllers;

import com.ivoronline.springboot_mockito_argumentcaptor.entities.Person;
import com.ivoronline.springboot_mockito_argumentcaptor.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  @ResponseBody
  @RequestMapping("/GetPerson")
  public String getPerson(@RequestParam Integer id) {

    //GET PERSON
    Person  person = personRepository.getPersonById(id);
    String  name   = person.name;
    Integer age    = person.age;

    //RETURN SOMETHING
    return name + " is " + age + " years old";

  }

}
