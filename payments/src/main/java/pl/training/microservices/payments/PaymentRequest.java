package pl.training.microservices.payments;

import lombok.Data;


@Data
public class PaymentRequest {

	private Long amount;
	private CreditCard creditCard;

}
