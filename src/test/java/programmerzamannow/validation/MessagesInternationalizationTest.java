package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessagesInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testI18N() {

        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("18238123817984918");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {

        Payment payment = new Payment();
        payment.setOrderId("18238123817984918");
        payment.setAmount(10L);

        Locale locale = new Locale("id", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println(message);

            System.out.println("===============");
        }
    }
}
