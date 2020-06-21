package pl.training.microservices.payments.api;

import lombok.Data;

import java.time.Instant;


@Data
public class PaymentTO {

	private Long id;
	private PaymentStatusTO status;
	private Instant timestamp;

}
