package pl.training.microservices.orders.payments;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;
import pl.training.microservices.payments.api.CreditCardTO;
import pl.training.microservices.payments.api.PaymentRequestTO;
import pl.training.microservices.payments.api.PaymentStatusTO;
import pl.training.microservices.payments.api.PaymentTO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PaymentsMapper {

    Payment toPayment(PaymentTO paymentTO);

    @ValueMapping(source = "NOT_CONFIRMED", target = "STARTED")
    PaymentStatus TOPaymentStatus(PaymentStatusTO paymentStatusTO);

    PaymentRequestTO toPaymentRequestTo(PaymentsRequest paymentsRequest);

    CreditCardTO toCreditCardTo(CreditCard creditCard);

}
