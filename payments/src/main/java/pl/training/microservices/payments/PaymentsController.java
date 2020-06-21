package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.training.microservices.payments.api.PaymentRequestTO;
import pl.training.microservices.payments.api.PaymentTO;
import pl.training.microservices.payments.api.Payments;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class PaymentsController implements Payments {

	private final PaymentsService paymentsService;
	private final PaymentsMapper paymentsMapper;


	@Override
	public ResponseEntity<PaymentTO> process(PaymentRequestTO paymentRequestTO) {
		PaymentRequest paymentRequest=paymentsMapper.toPaymentRequest(paymentRequestTO);
		Payment payment=paymentsService.process(paymentRequest);
		return ResponseEntity.accepted().body(paymentsMapper.toPaymentTO(payment));
	}

	//ResponseEntity -> odpowiednik odpowiedzi http i mozemy wtedy wstawic body, status  -> wrapper
/*	@Override
	public PaymentTO process(PaymentRequestTO paymentRequestTO) {
		PaymentRequest paymentRequest=paymentsMapper.toPaymentRequest(paymentRequestTO);
		Payment payment=paymentsService.process(paymentRequest);
		return paymentsMapper.toPaymentTO(payment);
	}*/
//domyślnie ->

	@Override
	public List<PaymentTO> getPayments() {
		return paymentsMapper.toPaymentTOs(paymentsService.getAllPayments());
	}

}





