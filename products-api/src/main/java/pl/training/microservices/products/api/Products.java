package pl.training.microservices.products.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("products-service")
@RequestMapping("products")
public interface Products {

	@PostMapping
	public ProductTo addNewProduct(@RequestBody ProductTo product);

	@GetMapping
	public List<ProductTo> getAllProducts();

	@GetMapping("/nameContains")
	public List<ProductTo> getAllProductsWithNameContains(@RequestParam String name);

	@GetMapping("/pageable")
	public List<ProductTo> getAllProductsWithPaging(Pageable pageable, @RequestParam String field);

}
