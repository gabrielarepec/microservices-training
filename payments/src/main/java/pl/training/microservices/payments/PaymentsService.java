package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Log
@RequiredArgsConstructor
@Service
public class PaymentsService {

	private final PaymentsRepository paymentsRepository;

	public Payment process(PaymentRequest paymentRequest) {
		//processing..
		log.info("New payment request: " + paymentRequest);
		final Payment payment = Payment.builder()
				.status(PaymentStatus.STARTED)
				.timestamp(Instant.now())
				.build();
		log.info("New payment: " + payment);
		return paymentsRepository.save(payment);

	}

	public List<Payment> getAllPayments() {
		return paymentsRepository.findAll();
	}

}
