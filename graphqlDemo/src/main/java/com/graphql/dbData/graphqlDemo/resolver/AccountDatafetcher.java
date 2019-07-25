package com.graphql.dbData.graphqlDemo.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.dbData.graphqlDemo.model.Account;
import com.graphql.dbData.graphqlDemo.repository.AccountRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@SuppressWarnings("rawtypes")
@Component
public class AccountDatafetcher{/* implements  DataFetcher   {

	@Autowired
	AccountRepository arepo;

	@Override
	public List<Account> get(DataFetchingEnvironment environment) throws Exception {
		return arepo.findAll();
	}

	*/
}
