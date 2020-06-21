package pl.training.microservices.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Log
@RequiredArgsConstructor
@Service
public class ProductsService {

	private final ProductsRepository productsRepository;

	public Product saveNewProduct(Product product) {
		//processing..

		log.info("New product: " + product);
		return productsRepository.save(product);

	}

	public List<Product> getAllProducts() {
		return productsRepository.findAll();
	}

	public List<Product> getAllProductsWithNameContains(String name) {
		return productsRepository.findAllByNameContains(name);
	}

	public List<Product> getAllProductsWithPaging(Pageable pageable) {
		return productsRepository.findAll(pageable).getContent();
	}

}
