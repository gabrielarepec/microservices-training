package pl.training.microservices.payments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long id;
	private PaymentStatus status;
	private Instant timestamp;

}
