package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest {

    @Test
    void testHibernateValidatorConstraint() {

        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("0001");
        payment.setCreditCard("455");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstraintValid() {

        Payment payment = new Payment();
        payment.setAmount(10_000_000L);
        payment.setOrderId("0001");
        payment.setCreditCard("455555555555555");

        validate(payment);
    }
}
