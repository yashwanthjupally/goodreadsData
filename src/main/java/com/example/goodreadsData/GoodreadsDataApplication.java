package com.example.goodreadsData;

import com.example.goodreadsData.Author.Author;
import com.example.goodreadsData.AuthorRepository.AuthorRepository;
import com.example.goodreadsData.AuthorService.AuthorService;
import connection.DatastaxAstraProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.nio.file.Path;

@EnableConfigurationProperties(DatastaxAstraProperties.class)
@EnableCassandraRepositories(basePackages = "com.example.goodreadsData.repository") // Ensure this is the correct package
@SpringBootApplication
public class GoodreadsDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodreadsDataApplication.class, args);
	}

	@Autowired
	AuthorService authorService;

	@PostConstruct
	public void start() {
		System.out.println("app");
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DatastaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}
}
