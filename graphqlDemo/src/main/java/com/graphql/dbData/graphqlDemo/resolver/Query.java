package com.graphql.dbData.graphqlDemo.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.dbData.graphqlDemo.model.Account;
import com.graphql.dbData.graphqlDemo.model.Client;
import com.graphql.dbData.graphqlDemo.repository.AccountRepository;
import com.graphql.dbData.graphqlDemo.repository.ClientRepository;

@Component
public class Query {/*implements GraphQLQueryResolver{

	private AccountRepository accountRepository;
	private ClientRepository clientRepository;

	public Query(AccountRepository accountRepository, ClientRepository clientRepository) {
		this.accountRepository = accountRepository;
		this.clientRepository = clientRepository;
	}

	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}

	public long countAccounts() {
		return accountRepository.count();
	}

	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElseThrow(null);
	}

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public long countClients() {
		return clientRepository.count();
	}

	public Client getClientById(Long id) {
		return clientRepository.findById(id).orElseThrow(null);
	}*/

}