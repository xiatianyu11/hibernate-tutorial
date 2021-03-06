package com.rain.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	private String userName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_PERSION",
		joinColumns=@JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="PERSION_ID"))
	private Collection<Persion> children = new HashSet<Persion>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Role> roles = new HashSet<Role>();

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Persion> getChildren() {
		return children;
	}

	public void setChildren(Collection<Persion> children) {
		this.children = children;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	
	

}
