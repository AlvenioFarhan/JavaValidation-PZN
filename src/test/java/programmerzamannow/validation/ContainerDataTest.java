package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {

        Person person = new Person();
        person.setFirstName("Alvenio");
        person.setFirstName("Farhan");
        person.setAddress(new Address());
        person.getAddress().setCity("Semarang");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Tembalang");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("  ");
        person.getHobbies().add("Coding");

        validate(person);
    }
}
