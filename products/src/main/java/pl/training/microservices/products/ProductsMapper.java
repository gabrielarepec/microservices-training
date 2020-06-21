package pl.training.microservices.products;

import org.mapstruct.Mapper;
import pl.training.microservices.products.api.ProductTo;

import java.util.List;


//unmapperdSourcePolicy/target - polityka ignorowania
@Mapper(componentModel = "spring") //jednoczesnie mapper jest componentem springowym i mozemy go wstrzyknac
public interface ProductsMapper {


	Product toProduct(ProductTo productTo);
	ProductTo toProductTo(Product product);
	List<ProductTo> toPaymentTOs(List<Product> payments);


}
