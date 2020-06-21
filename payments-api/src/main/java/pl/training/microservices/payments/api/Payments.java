package pl.training.microservices.payments.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("payments-service")
@RequestMapping("payments")
public interface Payments {

	@PostMapping
	ResponseEntity<PaymentTO> process(PaymentRequestTO paymentRequestTO);

	@GetMapping
	 List<PaymentTO> getPayments();
}
