package com.xxx.xxx.service;

import com.xxx.xxx.domain.Person;
import com.xxx.xxx.domain.PersonRequest;
import com.xxx.xxx.utils.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TimeUnit.class})
@SuppressStaticInitializationFor("com.xxx.xxx.utils.SalaryCalculator")
public class PersonServiceTest {

    private PersonService personService;

    @Before
    public void setUp() {
        personService = new PersonService();
    }

    @Test
    public void should_return_james() throws Exception {
        //given
        mockStatic(TimeUnit.class);
        doNothing().when(TimeUnit.class, "sleep", mock(Long.class));

        PersonRequest james = new PersonRequest("James");

        //when
        Person person = personService.find(james);

        //then
        assertThat(person).isEqualToComparingFieldByField(new Person("Merson", "James", BigDecimal.valueOf(20)));
    }

    @Test
    public void should_return_none() {
        //given
        PersonRequest james1 = new PersonRequest("James1");

        //when
        Person person = personService.find(james1);

        //then
        assertThat(person).isEqualToComparingFieldByField(new Person("None", "None", BigDecimal.ZERO));
    }
}