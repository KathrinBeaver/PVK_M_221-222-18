package ru.mai.testwebproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.mai.testwebproject.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class TestWebProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWebProjectApplication.class, args);
    }

}
