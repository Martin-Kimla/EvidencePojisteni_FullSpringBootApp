package pojisteni.app.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderIndex() {
        return "pages/home/index";
    }

    @GetMapping("/oAplikaci")
    public String render() {
        return "pages/home/oAplikaci";
    }
}
