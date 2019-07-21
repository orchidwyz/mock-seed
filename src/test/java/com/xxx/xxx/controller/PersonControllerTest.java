package com.xxx.xxx.controller;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    private PersonController personController;
    @Mock
    private PersonService personService;

    @Before
    public void setUp() {
        personController = new PersonController(personService);
    }

    @Test
    public void should_return_name() {
        //given
        String name = "aaa";
        given(personService.find(argThat(argument -> name.equals(argument.getName()))))
                .willReturn(new Person("None", "None", BigDecimal.ZERO));

        //when
        String result = personController.getName(name);

        //then
        assertThat(result).isEqualTo("None,None");
    }
}