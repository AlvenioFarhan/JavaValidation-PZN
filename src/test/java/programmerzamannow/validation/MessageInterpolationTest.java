package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {

        Payment payment = new Payment();
        payment.setOrderId("127319827389129");
        payment.setVirtualAccount("3123121");
        payment.setAmount(10L);

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }
}
