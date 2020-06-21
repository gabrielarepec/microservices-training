package pl.training.microservices.payments.api;

import lombok.Data;


@Data
public class PaymentRequestTO {

	private Long amount;
	private CreditCardTO creditCard;

}
