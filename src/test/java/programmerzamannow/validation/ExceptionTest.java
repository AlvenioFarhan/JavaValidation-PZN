package programmerzamannow.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest {

    @Test
    void testException() {

//        Person person = new Person();
//        validateWithException(person);

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });
    }
}
