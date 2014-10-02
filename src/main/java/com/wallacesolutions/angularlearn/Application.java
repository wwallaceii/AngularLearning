package com.wallacesolutions.angularlearn;

/**
 * Created by wwallace on 7/23/14.
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wallacesolutions.angularlearn.repository.NoteRepository;

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
