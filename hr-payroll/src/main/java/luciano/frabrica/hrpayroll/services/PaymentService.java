package luciano.frabrica.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luciano.frabrica.hrpayroll.entities.Payment;
import luciano.frabrica.hrpayroll.entities.Worker;
import luciano.frabrica.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
//	@Value("${hr-worker.host}")
//	private String workerHost;
//	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long id, int days) {
	
		
		Worker w = workerFeignClient.findById(id).getBody();
		return new Payment(w.getName(), w.getDailyIncome(), days);
	}
}
