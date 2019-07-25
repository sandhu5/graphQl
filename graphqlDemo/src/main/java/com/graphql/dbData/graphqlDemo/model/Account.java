package com.graphql.dbData.graphqlDemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

//@Entity
public class Account {

//	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//@Column(name = "client_id")
	private Integer clientId;
	
	//@Column(name = "account_id")
	private Integer accountId;

	//@Column(name = "account_short_name")
	private String accountShortName;

	//@Column(name = "account_reg_name", nullable = false)
	private String accountRegName;

	//@Column(name = "account_number")
	private String accountNumber;

	//@Column(name = "rep_number")
	private Integer repNumber;

	//@Column(name = "management_name")
	private String managementName;

	//@ManyToMany(mappedBy = "accounts")
	private List<Client> clients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getAccountShortName() {
		return accountShortName;
	}

	public void setAccountShortName(String accountShortName) {
		this.accountShortName = accountShortName;
	}

	public String getAccountRegName() {
		return accountRegName;
	}

	public void setAccountRegName(String accountRegName) {
		this.accountRegName = accountRegName;
	}

	public Integer getRepNumber() {
		return repNumber;
	}

	public void setRepNumber(Integer repNumber) {
		this.repNumber = repNumber;
	}

	public String getManagementName() {
		return managementName;
	}

	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
