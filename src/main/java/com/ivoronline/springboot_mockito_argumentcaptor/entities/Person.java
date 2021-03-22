package com.ivoronline.springboot_mockito_argumentcaptor.entities;

public class Person {

  //PROPERTIES
  public Integer id;
  public String  name;
  public Integer age;

  //CONSTRUCTOR
  public Person(Integer id, String name, Integer age) {
    this.id   = id;
    this.name = name;
    this.age  = age;
  }

}
