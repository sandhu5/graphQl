package com.graphql.dbData.graphqlDemo.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.dbData.graphqlDemo.model.Client;
import com.graphql.dbData.graphqlDemo.repository.ClientRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@SuppressWarnings("rawtypes")
@Component
public class ClientDatafetcher {/* implements  DataFetcher   {

	@Autowired
	ClientRepository crepo;

	@Override
	public List<Client> get(DataFetchingEnvironment environment) throws Exception {
		return crepo.findAll();
	}
*/
	
}
