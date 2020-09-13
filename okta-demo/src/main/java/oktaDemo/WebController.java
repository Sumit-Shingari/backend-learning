package oktaDemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome home!";
    }

    @PreAuthorize("hasAuthority('SCOPE_custom')")
    @RequestMapping("/restricted")
    @ResponseBody
    public String restricted() {
        return "You found the secret lair!";
    }
    
}