package com.graphql.dbData.graphqlDemo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.graphql.dbData.graphqlDemo.model.Account;
import com.graphql.dbData.graphqlDemo.model.Client;

import graphql.schema.DataFetcher;

@Repository
public class ClientData {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * @SuppressWarnings("rawtypes") public DataFetcher getClientByIdDataFetcher() {
	 * return dataFetchingEnvironment -> { String clientId =
	 * dataFetchingEnvironment.getArgument("id").toString(); Client client =
	 * jdbcTemplate.query(
	 * "Select * from \"CLIENT\".client as c inner join \"CLIENT\".account as a on  a.client_id = c.client_id  where c.client_id = ? "
	 * , new Object[] { Integer.parseInt(clientId) }, new ClientExtractor()); return
	 * client; }; }
	 */
	
	@SuppressWarnings("rawtypes")
	public DataFetcher getClientByIdDataFetcher() {
		return dataFetchingEnvironment -> {
			String clientId = dataFetchingEnvironment.getArgument("id").toString();
			Client client = jdbcTemplate.query(
					"Select * from \"CLIENT\".client as c where c.client_id = ? limit 1 ",
					new Object[] { Integer.parseInt(clientId) }, new ClientExtractor());
			return client;
		};
	}
	
	
	
	public DataFetcher getAccountDataFetcher() {
		return dataFetchingEnvironment -> {
			Client client = dataFetchingEnvironment.getSource();
			int clientId = client.getClientId();
			List<Account> accounts = jdbcTemplate.query(
					"Select * from \"CLIENT\".account where client_id = ? ",
					new Object[] {clientId }, new AccountExtractor());
			return accounts;
		};
	}
}

class ClientExtractor implements ResultSetExtractor<Client> {

	Map<Integer, Client> map = new HashMap<>();

	@Override
	public Client extractData(ResultSet rs) throws SQLException, DataAccessException {
		Client client = new Client();
	//	List<Account> accounts = new ArrayList<>();

		while (rs.next()) {
			//Account account = new Account();
			if (map.get(rs.getInt("client_id")) == null) {
				client.setPartyRoleId(rs.getInt("party_role_id"));
				client.setClientId(rs.getInt("client_id"));
				client.setFirstName(rs.getString("first_name"));
				client.setLastName(rs.getString("last_name"));
				/*
				 * account.setAccountNumber(rs.getString("account_number"));
				 * account.setAccountRegName(rs.getString("account_reg_name"));
				 * account.setRepNumber(rs.getInt("rep_number"));
				 * account.setAccountId(rs.getInt("account_id")); accounts.add(account);
				 * client.setAccounts(accounts);
				 */
				map.put(rs.getInt("client_id"), client);
			} else {
				Client temp = map.get(rs.getInt("client_id"));
				/*
				 * account.setAccountNumber(rs.getString("account_number"));
				 * account.setAccountRegName(rs.getString("account_reg_name"));
				 * account.setRepNumber(rs.getInt("rep_number"));
				 * account.setAccountId(rs.getInt("account_id"));
				 * temp.getAccounts().add(account);
				 */
			}

		}
		return client;
	}
}

class AccountExtractor implements ResultSetExtractor<List<Account>>{

	@Override
	public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Account> accounts = new ArrayList<Account>();
		while(rs.next()) {
			Account account = new Account();
			account.setAccountId(rs.getInt("account_id"));
			account.setAccountNumber(rs.getString("account_number"));
			account.setRepNumber(rs.getInt("rep_number"));
			accounts.add(account);
		}
		return accounts;
	}
	
}
