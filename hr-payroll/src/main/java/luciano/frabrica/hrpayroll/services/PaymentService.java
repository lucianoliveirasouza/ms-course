package luciano.frabrica.hrpayroll.services;

import org.springframework.stereotype.Service;

import luciano.frabrica.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long id, int days) {
		return new Payment("Bob",200.0,days);
	}
}
