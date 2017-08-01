package evolution.service.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnyService {
	private AnotherService anotherService;

	@Autowired
	private TheOtherService theOtherService;// Setter Injection
	
	@Autowired
	public AnyService(AnotherService anotherService) {// Constructor Injection
		this.anotherService = anotherService;
	}
	
	public String anyMethod() {
		return "";
	}
}
