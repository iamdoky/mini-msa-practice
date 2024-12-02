package iam.doky.bookapi.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open-book")
@Slf4j
public class HealthController {

    Environment env;

    public HealthController(Environment env){
        this.env = env;
    }

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome First Service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){

        log.info(header);
        return "Hello First Service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){

        log.info("Server port={}", request.getServerPort());
        return "Check First Service on PORT %s".formatted(env.getProperty("local.server.port"));
    }
}
