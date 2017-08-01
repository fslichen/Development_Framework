package spring.boot;

import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import evolution.service.injection.AnyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnyClass {
	@MockBean
	private AnyService anyService;

	@Test
	public void exampleTest() {
		// RemoteService has been injected into the reverser bean
		given(this.anyService.anyMethod()).willReturn("mock");
	}
}
