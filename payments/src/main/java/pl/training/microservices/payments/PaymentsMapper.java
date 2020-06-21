package pl.training.microservices.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import pl.training.microservices.payments.api.CreditCardTO;
import pl.training.microservices.payments.api.PaymentRequestTO;
import pl.training.microservices.payments.api.PaymentStatusTO;
import pl.training.microservices.payments.api.PaymentTO;

import java.util.List;

//unmapperdSourcePolicy/target - polityka ignorowania
@Mapper(componentModel = "spring") //jednoczesnie mapper jest componentem springowym i mozemy go wstrzyknac
public interface PaymentsMapper {

	@Mapping(source = "expiration",target = "expirationDate")
	CreditCard toCreditCard(CreditCardTO creditCardTO);
	PaymentRequest toPaymentRequest(PaymentRequestTO paymentRequestTO);
	PaymentTO toPaymentTO(Payment payment);

	List<PaymentTO> toPaymentTOs(List<Payment> payments);

	@ValueMapping(source = "STARTED", target = "NOT_CONFIRMED")
	PaymentStatusTO toPaymentStatusTO(PaymentStatus paymentStatus);

}
