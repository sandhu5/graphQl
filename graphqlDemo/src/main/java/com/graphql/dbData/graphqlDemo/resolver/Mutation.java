package com.graphql.dbData.graphqlDemo.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.dbData.graphqlDemo.model.Account;
import com.graphql.dbData.graphqlDemo.model.Client;
import com.graphql.dbData.graphqlDemo.repository.AccountRepository;
import com.graphql.dbData.graphqlDemo.repository.ClientRepository;

@Component
public class Mutation {/* implements GraphQLMutationResolver {

	private AccountRepository accountRepository;
	private ClientRepository clientRepository;

	public Mutation(AccountRepository accountRepository, ClientRepository clientRepository) {
		this.accountRepository = accountRepository;
		this.clientRepository = clientRepository;
	}

	public Account newAccount(String accountShortName, Integer repNumber) {
		Account account = new Account();
		accountRepository.save(account);
		return account;
	}

	public boolean deleteAccount(Long id) {
		accountRepository.deleteById(id);
		return true;
	}

	public Client newClient(String firstName,String lastName ,Integer partyRoleId ,Integer governmentId) {
		Client client = new Client();
		clientRepository.save(client);
		return client;
	}

	public boolean deleteClient(Long id) {
		clientRepository.deleteById(id);
		return true;
	}
*/
}