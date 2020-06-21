package pl.training.microservices.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private long price;

}
