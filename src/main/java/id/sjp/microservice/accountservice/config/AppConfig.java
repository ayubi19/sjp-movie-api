package id.sjp.microservice.accountservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages =
        {
                "sjp.id.microservice.accountservice.config",
                "sjp.id.microservice.accountservice.controller",
                "sjp.id.microservice.accountservice.service"
        }
)
@EnableAspectJAutoProxy
public class AppConfig {
}
