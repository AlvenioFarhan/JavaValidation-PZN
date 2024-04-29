package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest {

    @Test
    void testValidateConstructorParameter() throws NoSuchMethodException {

        String firstname = "";
        String lastname = "";
        Address address = null;

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorParameters(constructor, new Object[]{});

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======================");
        }
    }

    @Test
    void testValidateConstructorReturnValue() throws NoSuchMethodException {

        String firstname = "";
        String lastname = "";
        Address address = null;

        Person person = new Person(firstname, lastname, address);

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorReturnValue(constructor, person);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======================");
        }
    }
}
