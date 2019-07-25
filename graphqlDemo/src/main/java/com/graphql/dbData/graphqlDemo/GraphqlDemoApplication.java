package com.graphql.dbData.graphqlDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.graphql.dbData.graphqlDemo.repository.AccountRepository;
import com.graphql.dbData.graphqlDemo.repository.ClientRepository;
import com.graphql.dbData.graphqlDemo.resolver.Mutation;
import com.graphql.dbData.graphqlDemo.resolver.Query;

@SpringBootApplication
@Configuration
@ComponentScan("com.graphql.dbData")

public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}

	/*
	 * @Bean public Query query(AccountRepository accountRepository,
	 * ClientRepository clientRepository) { return new Query(accountRepository,
	 * clientRepository); }
	 * 
	 * @Bean public Mutation mutation(AccountRepository accountRepository,
	 * ClientRepository clientRepository) { return new Mutation(accountRepository,
	 * clientRepository); }
	 */
}
