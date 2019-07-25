package com.graphql.dbData.graphqlDemo;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.graphql.dbData.graphqlDemo.repository.ClientData;
import com.graphql.dbData.graphqlDemo.resolver.AccountDatafetcher;
import com.graphql.dbData.graphqlDemo.resolver.ClientDatafetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLProvider {


    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;
    
    @Autowired
    ClientData cdata;
    
    @Autowired
    ClientDatafetcher clientDatafetcher;

    @Autowired
    AccountDatafetcher accountDatafetcher;
    
    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

	private RuntimeWiring buildWiring() {// getClientByIdDataFetcher
		return RuntimeWiring.newRuntimeWiring()
				.type(newTypeWiring("Query").dataFetcher("getClientById", cdata.getClientByIdDataFetcher()))
				.type(newTypeWiring("Client").dataFetcher("accounts", cdata.getAccountDataFetcher()))

				/*
				 * .type(newTypeWiring("Client") .dataFetcher("getClients",clientDatafetcher ))
				 */
				.type(newTypeWiring("Query").dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))

				.type(newTypeWiring("Book").dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))

				.build();
	}

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

}
