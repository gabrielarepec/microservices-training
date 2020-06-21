package pl.training.microservices.products;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.training.microservices.products.api.ProductTo;
import pl.training.microservices.products.api.Products;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController implements Products {

	private final ProductsService productsService;
	private final ProductsMapper productsMapper;

	@Override
	public ProductTo addNewProduct(@RequestBody ProductTo productTo) {
		return this.productsMapper
				.toProductTo(this.productsService.saveNewProduct(this.productsMapper.toProduct(productTo)));
	}

	@Override
	public List<ProductTo> getAllProducts() {

		return this.productsMapper.toPaymentTOs(this.productsService.getAllProducts());
	}

	@Override
	public List<ProductTo> getAllProductsWithNameContains(@RequestParam String name) {
		log.info("NAME TO SEARCH: {} ", name);
		return this.productsMapper.toPaymentTOs(this.productsService.getAllProductsWithNameContains(name));
	}

	@Override
	public List<ProductTo> getAllProductsWithPaging(Pageable pageable) {
		log.info("getAllProductsWithPaging : called with params : {} ", pageable);
		return this.productsMapper.toPaymentTOs(this.productsService.getAllProductsWithPaging(pageable));
	}

}
