package luciano.frabrica.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import luciano.frabrica.hrpayroll.entities.Payment;
import luciano.frabrica.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days){
		Payment payment = service.getPayment(id, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long id, Integer days){
		Payment p = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(p);
	}
}
