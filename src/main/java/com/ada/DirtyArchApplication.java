package com.ada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ada.model")
@EnableJpaRepositories("com.ada.repository")
public class DirtyArchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirtyArchApplication.class, args);
    }

}
