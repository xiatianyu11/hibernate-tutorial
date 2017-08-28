package com.rain.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	private String userName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="CN_NAME")),
		@AttributeOverride(name="phone", column=@Column(name="CN_PHONE"))
	})
	private UserDetail cnUserDetail;
	
	@Embedded
	private UserDetail enUserDetail;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator="hilo-gen", type=@Type(type="long"))
	private Collection<Address> addressOfList = new HashSet<Address>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDetail getCnUserDetail() {
		return cnUserDetail;
	}

	public void setCnUserDetail(UserDetail cnUserDetail) {
		this.cnUserDetail = cnUserDetail;
	}

	public UserDetail getEnUserDetail() {
		return enUserDetail;
	}

	public void setEnUserDetail(UserDetail enUserDetail) {
		this.enUserDetail = enUserDetail;
	}

	public Collection<Address> getAddressOfList() {
		return addressOfList;
	}

	public void setAddressOfList(Collection<Address> addressOfList) {
		this.addressOfList = addressOfList;
	}

	
	

}
