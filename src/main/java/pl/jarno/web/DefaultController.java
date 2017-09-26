package pl.jarno.web;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping("/")
	public String helloView() {
		return "{hello: World}";
	}

}
