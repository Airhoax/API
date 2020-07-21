package api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Strings;

@Controller
public class htmlVisible<stirng> {
	@RequestMapping(value = "/index")
	   public String index() {
	      return "index";
	   }
	@RequestMapping(value = "/warehouse")
	   public String warehouse() {
	      return "warehouse";
	   }
	@RequestMapping(value = "/sales")
	   public String sales() {
	      return "sales";
	   }
}
