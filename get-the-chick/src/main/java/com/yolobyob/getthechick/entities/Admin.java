package com.yolobyob.getthechick.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details of Admin")
@Entity(name = "admin_table")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "name cannot be null for admin")
	@ApiModelProperty(notes = "Admin name, Cannot be null")
	String adminName;
	
	@NotNull(message = "Password cannot be null for admin")
	@ApiModelProperty(notes = "Admin password, Cannot be null")
	String password;
	
	@NotNull(message = "role cannot be null for admin")
	@ApiModelProperty(notes = "Admin role, Cannot be null")
	String role;

	public Admin() {
		
	}
	
	public Admin(Long id, @NotNull String adminName, @NotNull String password, @NotNull String role) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
