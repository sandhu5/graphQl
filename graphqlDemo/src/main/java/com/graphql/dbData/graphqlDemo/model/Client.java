package com.graphql.dbData.graphqlDemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

//@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//@Column(name = "client_id")
	private Integer clientId;

	//@Column(name = "party_role_id")
	private Integer partyRoleId;

	//@Column(name = "broker_dealer_id")
	private Integer brokerDealerId;

	///@Column(name = "government_id")
	private Integer governmentId;

	//@Column(name = "preferred_name")
	private String preferredName;

	//@Column(name = "account_short_name")
	private String accountShortName;

	//@Column(name = "first_name")
	private String firstName;

	//@Column(name = "last_name")
	private String lastName;

	/*
	 * @ManyToMany(cascade = { CascadeType.ALL})
	 * 
	 * @JoinTable( name = "\"CLIENT\".account", joinColumns = { @JoinColumn(name =
	 * "client_id") }, inverseJoinColumns = { @JoinColumn(name = "account_id") } )
	 */
	List<Account>accounts;
	
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

	public Integer getPartyRoleId() {
		return partyRoleId;
	}

	public void setPartyRoleId(Integer partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

	public Integer getBrokerDealerId() {
		return brokerDealerId;
	}

	public void setBrokerDealerId(Integer brokerDealerId) {
		this.brokerDealerId = brokerDealerId;
	}

	public Integer getGovernmentId() {
		return governmentId;
	}

	public void setGovernmentId(Integer governmentId) {
		this.governmentId = governmentId;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getAccountShortName() {
		return accountShortName;
	}

	public void setAccountShortName(String accountShortName) {
		this.accountShortName = accountShortName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


}
