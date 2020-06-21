package pl.training.microservices.orders.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@FeignClient("orders-service")
@RequestMapping("orders")
public interface Orders {

	@PostMapping
	ResponseEntity<Void> placeOrder(@RequestBody @Valid OrderTo orderTo, BindingResult bindingResult);

}
