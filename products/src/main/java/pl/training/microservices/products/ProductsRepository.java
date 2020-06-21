package pl.training.microservices.products;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Product, Long> {

	public List<Product> findAllByNameContains(String name);


}
