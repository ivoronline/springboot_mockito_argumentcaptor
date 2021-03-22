package com.ivoronline.springboot_mockito_argumentcaptor.controllers;

import com.ivoronline.springboot_mockito_argumentcaptor.entities.Person;
import com.ivoronline.springboot_mockito_argumentcaptor.respositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @Mock PersonRepository personRepositoryMock;

  //INJECT MOCKS (where @autowired is used)
  @InjectMocks MyController myController;

  //ENDPOINT
  @Test
  void getPerson() {

    //CREATE CAPTOR THAT CAPTURES INTEGER ARGUMENTS
		//ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

    //MOCK REPOSITORY METHOD
    when(personRepositoryMock.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));
    when(personRepositoryMock.getPersonById(2)).thenReturn(new Person(1, "Susan", 50));

    //CALL REPOSITORY METHOD
    myController.getPerson(1);
    myController.getPerson(2);

		//CAPTURE INTEGER ARGUMENT (from last call)
    ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(personRepositoryMock, times(2)).getPersonById(integerArgumentCaptor.capture());

		//GET LAST CAPTURED ARGUMENT
		Integer argument = integerArgumentCaptor.getValue();

		//DISPLAY CAPTURED ARGUMENT
		System.out.println(argument);

  }

}
