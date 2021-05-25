package id.sjp.movie.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "id.sjp.movie.api*"
})
@SpringBootApplication
public class SjpMovieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjpMovieApiApplication.class, args);
    }

}
