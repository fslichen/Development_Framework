package evolution.service.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {
	private BetaService anotherService;

	@Autowired
	private GammaService theOtherService;// Setter Injection
	
	@Autowired
	public AlphaService(BetaService anotherService) {// Constructor Injection
		this.anotherService = anotherService;
	}
}
