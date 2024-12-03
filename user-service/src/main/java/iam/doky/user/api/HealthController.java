package iam.doky.user.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class HealthController {

    Environment env;

    public HealthController(Environment env){
        this.env = env;
    }

    @GetMapping("/health-check")
    public String status(){

        return String.format("It's Working in user service " +
                ", port " + env.getProperty("local.server.port") +
                ", server.port " + env.getProperty("server.port") +
                ", token.secret " + env.getProperty("token.secret") +
                ", token.expiration_time " + env.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome Second Service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){

        log.info(header);
        return "Hello Second Service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){

        log.info("Server port={}", request.getServerPort());
        return "Check Second Service on PORT %s".formatted(env.getProperty("local.server.port"));
    }
}
