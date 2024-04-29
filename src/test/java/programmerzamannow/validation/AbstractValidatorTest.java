package programmerzamannow.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============");
        }
    }

    void validateWithGroup(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============");
        }
    }
}
