package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleID")
	private int roleId;
	
	@Column(name="rolename")
	private String roleName;
	
//	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name="userroles", 
//	joinColumns = @JoinColumn(name = "RoleID", referencedColumnName="RoleID"),
//	inverseJoinColumns = @JoinColumn(name="UserID", referencedColumnName="UserID"))
//	private Set<User> user;
//	@OneToMany(mappedBy= "roles")
//	private List<UserRoles> userRoles;
}
