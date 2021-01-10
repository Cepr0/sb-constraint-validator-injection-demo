package io.github.cepr0.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Predicate;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostMapping("/demo")
    public ResponseEntity<?> demo(@RequestBody @Valid DemoRequest request) {
        return ResponseEntity.ok(request);
    }

    // @Bean
    // public MethodValidationPostProcessor methodValidationPostProcessor(LocalValidatorFactoryBean validator) {
    //     var postProcessor = new MethodValidationPostProcessor();
    //     postProcessor.setValidator(validator);
    //     return postProcessor;
    // }

    @Bean
    public Predicate<String> uppercasePredicate() {
        return text -> text != null && text.chars().allMatch(Character::isUpperCase);
    }

    @Bean
    public Predicate<String> lowercasePredicate() {
        return text -> text != null && text.chars().allMatch(Character::isLowerCase);
    }
}
