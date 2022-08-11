package com.ecommerce.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userroles")
public class UserRoles {
	
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="RoleID")
	private Roles roles;
}
